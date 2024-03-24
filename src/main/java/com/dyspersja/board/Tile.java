package com.dyspersja.board;

import com.dyspersja.pieces.ChessPiece;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tile {

    private int attackedBy;
    private ChessPiece piece;

    public void incrementAttackedBy() {
        attackedBy++;
    }
}
