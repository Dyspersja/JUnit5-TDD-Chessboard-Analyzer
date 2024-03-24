package com.dyspersja.board;

import com.dyspersja.pieces.ChessPiece;
import lombok.Getter;

@Getter
public class Tile {

    private int attackedBy;
    private ChessPiece piece;
}
