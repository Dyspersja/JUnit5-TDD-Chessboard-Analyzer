package com.dyspersja.pieces;

import com.dyspersja.board.Tile;

public class Knight extends ChessPiece {

    public Knight(int x, int y) {
        super(x, y);
    }

    @Override
    public void calculateAttacks(Tile[][] board) {
        if(x >= board.length || y >= board[0].length)
            throw new IllegalStateException("Knight is not placed inside the board");
    }
}
