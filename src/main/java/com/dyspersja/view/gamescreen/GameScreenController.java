package com.dyspersja.view.gamescreen;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class GameScreenController {

    @FXML // fx:id="minefieldGridPane"
    private GridPane minefieldGridPane;

    public void initializeGameScreenController(int height, int width) {
        var initializer = new GameScreenInitializer(minefieldGridPane);

        initializer.clearGridConstraints();
        initializer.addRowConstraints(height);
        initializer.addColumnConstraints(width);
        initializer.applyGridPaneStyles();

        initializeGameLogic(height, width);
    }

    private void initializeGameLogic(int height, int width) {
        var logic = new GameScreenLogic(this, height, width);
        logic.initializeTileGrid(minefieldGridPane);
    }
}
