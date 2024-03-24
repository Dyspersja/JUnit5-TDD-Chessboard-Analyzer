package com.dyspersja.view.model;

import com.dyspersja.board.Tile;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import lombok.Getter;

@Getter
public class GridTile extends Label {

    private final int x;
    private final int y;
    private final Tile tile;

    private final GridTileStyle defaultStyle;

    public GridTile(Tile tile, int x, int y) {
        this.tile = tile;
        this.x = x;
        this.y = y;

        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.setAlignment(Pos.CENTER);

        int pattern = 0;
        if (x % 2 == 0) pattern++;
        if (y % 2 == 0) pattern++;

        if(pattern % 2 == 0) defaultStyle = GridTileStyle.DEFAULT_0;
        else defaultStyle = GridTileStyle.DEFAULT_1;

        this.applyStyle(defaultStyle);
    }

    public void applyText(String text) {
        this.setText(text);
    }

    public void applyStyle(GridTileStyle style) {
        this.setStyle(
                "-fx-font-weight: bold;" +
                        "-fx-background-color: " + style + ";" +
                        "-fx-border-color: #666666;" +
                        "-fx-border-width: 1px;"
        );
    }
}
