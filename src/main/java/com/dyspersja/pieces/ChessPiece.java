package com.dyspersja.pieces;

import com.dyspersja.board.Tile;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class ChessPiece {

    protected int x;
    protected int y;

    public abstract void calculateAttacks(Tile[][] board);
}
