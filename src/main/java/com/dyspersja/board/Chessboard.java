package com.dyspersja.board;

import lombok.Getter;

@Getter
public class Chessboard {

    private static final int MIN_WIDTH = 6;
    private static final int MAX_WIDTH = 70;
    private static final int MIN_HEIGHT = 6;
    private static final int MAX_HEIGHT = 40;

    private final int width;
    private final int height;

    private final Tile[][] board;

    public Chessboard(int width, int height) {
        if( width < MIN_WIDTH || width > MAX_WIDTH || height < MIN_HEIGHT || height > MAX_HEIGHT)
            throw new IllegalArgumentException("Invalid Checkerboard size");

        this.width = width;
        this.height = height;

        this.board = initializeBoard(width, height);
    }

    private Tile[][] initializeBoard(int width, int height){
        Tile[][] board = new Tile[width][height];

        for (int column = 0; column < width; column++)
            for (int row = 0; row < height; row++)
                board[column][row] = new Tile();

        return board;
    }

    public Tile getTile(int x, int y) {
        return board[x][y];
    }

}
