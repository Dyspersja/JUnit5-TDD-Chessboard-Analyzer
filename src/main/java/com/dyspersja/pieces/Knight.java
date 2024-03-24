package com.dyspersja.pieces;

import com.dyspersja.board.Tile;

public class Knight extends ChessPiece {

    private static final int[][] MOVES = {
            {1, 2}, {-1, 2}, {1, -2}, {-1, -2},
            {2, 1}, {-2, 1}, {2, -1}, {-2, -1}
    };

    public Knight(int x, int y) {
        super(x, y, "\u265E");
    }

    @Override
    public void calculateAttacks(Tile[][] board) {
        int boardWidth = board[0].length;
        int boardHeight = board.length;

        if(!isValidPosition(boardWidth, boardHeight, x, y))
            throw new IllegalStateException("Knight is not placed inside the board");

        for (int[] move : MOVES) {
            int newX = getX() + move[0];
            int newY = getY() + move[1];

            if (isValidPosition(boardWidth, boardHeight, newX, newY)) {
                board[newX][newY].incrementAttackedBy();
            }
        }
    }
}
