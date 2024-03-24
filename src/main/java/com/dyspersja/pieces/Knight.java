package com.dyspersja.pieces;

import com.dyspersja.board.Tile;

public class Knight extends ChessPiece {

    public Knight(int x, int y) {
        super(x, y);
    }

    @Override
    public void calculateAttacks(Tile[][] board) {
        if(!isValidPosition(board[0].length, board.length, x, y))
            throw new IllegalStateException("Knight is not placed inside the board");
    }
}
