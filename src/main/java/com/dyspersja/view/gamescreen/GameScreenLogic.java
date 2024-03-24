package com.dyspersja.view.gamescreen;

import com.dyspersja.board.Chessboard;
import com.dyspersja.board.Tile;
import com.dyspersja.pieces.Knight;
import com.dyspersja.view.model.GridTile;
import com.dyspersja.view.model.GridTileStyle;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class GameScreenLogic {

    private final GameScreenController gameScreenController;

    private final Chessboard chessboard;
    private GridTile[][] tiles;
    private final int gridHeight;
    private final int gridWidth;

    public GameScreenLogic(
            GameScreenController gameScreenController,
            int gridHeight,
            int gridWidth
    ) {
        this.gameScreenController = gameScreenController;
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.chessboard = new Chessboard(gridWidth, gridHeight);
    }

    public void initializeTileGrid(GridPane minefieldGridPane) {
        tiles = new GridTile[gridWidth][gridHeight];

        for (int column = 0; column < gridWidth; column++) {
            for (int row = 0; row < gridHeight; row++) {
                GridTile tile = new GridTile(chessboard.getTile(column, row), column, row);

                assignInitialTileClickEvent(tile);
                setDefaultHoverHighlighting(tile);

                tiles[column][row] = tile;
                minefieldGridPane.add(tile, column, row);
            }
        }
    }

    private void assignInitialTileClickEvent(GridTile tile) {
        tile.setOnMouseClicked(mouseEvent -> {
            List<GridTile> highlightedTiles = addHoverHighlighting(tile);
            reassignTileClickEvent(tile, highlightedTiles);

            chessboard.placeKnight(tile.getX(), tile.getY());
            chessboard.calculateBoard();
            repaintTiles();
        });
    }

    private void reassignTileClickEvent(GridTile tile, List<GridTile> highlightedTiles) {
        tile.setOnMouseClicked(mouseEvent -> {
            clearHoveredTiles(highlightedTiles);
            assignInitialTileClickEvent(tile);
            setDefaultHoverHighlighting(tile);

            chessboard.removePiece(tile.getX(), tile.getY());
            chessboard.calculateBoard();
            repaintTiles();
        });
    }

    private List<GridTile> addHoverHighlighting(GridTile tile) {
        Knight knight = new Knight(tile.getX(), tile.getY());
        Tile[][] board = new Tile[gridWidth][gridHeight];
        for (int column = 0; column < gridWidth; column++) {
            for (int row = 0; row < gridHeight; row++) {
                board[column][row] = new Tile();
            }
        }

        knight.calculateAttacks(board);
        List<GridTile> tilesToHighlight = new ArrayList<>();

        for (int column = 0; column < gridWidth; column++) {
            for (int row = 0; row < gridHeight; row++) {
                if(board[column][row].getAttackedBy() == 1)
                    tilesToHighlight.add(tiles[column][row]);
            }
        }

        tile.applyStyle(tile.getDefaultStyle());
        paintHoveredTiles(tilesToHighlight);

        tile.setOnMouseEntered(mouseEvent -> {
            paintHoveredTiles(tilesToHighlight);
        });
        tile.setOnMouseExited(mouseEvent -> {
            tilesToHighlight.forEach(t -> t.applyStyle(t.getDefaultStyle()));
        });

        return tilesToHighlight;
    }

    private void paintHoveredTiles(List<GridTile> tilesToHighlight) {
        tilesToHighlight.forEach(t -> {
            if(!t.getTile().isOccupied())
                t.applyStyle(GridTileStyle.ATTACKED_HOVER);
        });
    }

    private void clearHoveredTiles(List<GridTile> highlightedTiles) {
        highlightedTiles.forEach(tile -> tile.applyStyle(tile.getDefaultStyle()));
    }

    private void setDefaultHoverHighlighting(GridTile tile) {
        tile.setOnMouseEntered(mouseEvent -> {
            tile.applyStyle(GridTileStyle.DEFAULT_HOVER);
        });
        tile.setOnMouseExited(mouseEvent -> {
            tile.applyStyle(tile.getDefaultStyle());
        });
    }

    private void repaintTiles() {
        for (int column = 0; column < gridWidth; column++) {
            for (int row = 0; row < gridHeight; row++) {
                String text = tiles[column][row].getTile().toString();

                if(text.equals("0")) tiles[column][row].setText(" ");
                else tiles[column][row].setText(text);
            }
        }
    }
}
