package com.dyspersja.pieces;

import com.dyspersja.board.Chessboard;
import com.dyspersja.board.Tile;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {

    @Test
    void shouldAssignPositionWhenCreated() {
        // Given
        int x = 2;
        int y = 1;

        // When
        Knight knight = new Knight(x, y);

        // Then
        assertEquals(x, knight.getX());
        assertEquals(y, knight.getY());
    }

    @Test
    void shouldThrowExceptionWhenInvalidPosition() {
        // Given
        Knight knight = new Knight(20,8);
        Tile[][] board = new Tile[10][15];

        // When
        assertThatThrownBy(() -> knight.calculateAttacks(board))
                // Then
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Knight is not placed inside the board");
    }

    @Test
    void shouldUpdateAttackedByValuesForKnight() {
        // Given
        int width = 6;
        int height = 8;
        Chessboard chessboard = new Chessboard(width, height);

        int xPosition = 5;
        int yPosition = 3;
        ChessPiece knight = new Knight(xPosition, yPosition);
        Tile[][] board = chessboard.getBoard();

        // When
        knight.calculateAttacks(board);

        // Then
        assertEquals(1, board[3][2].getAttackedBy());
        assertEquals(1, board[3][4].getAttackedBy());
        assertEquals(1, board[4][1].getAttackedBy());
        assertEquals(1, board[4][5].getAttackedBy());

        assertEquals(0, board[0][0].getAttackedBy());
        assertEquals(0, board[4][2].getAttackedBy());
        assertEquals(0, board[2][4].getAttackedBy());
        assertEquals(0, board[2][1].getAttackedBy());

        assertEquals(0, board[xPosition][yPosition].getAttackedBy());
    }

    @Test
    public void shouldReturnChessKnightSymbol() {
        // Given
        Knight knight = new Knight(0, 0);

        // When
        String result = knight.toString();

        // Then
        assertEquals("\u265E", result);
        assertEquals("♞", result);
    }
}
