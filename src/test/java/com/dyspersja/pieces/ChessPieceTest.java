package com.dyspersja.pieces;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class ChessPieceTest {

    @ParameterizedTest
    @CsvSource({
            "6, 6, 6, 6",       // both too high
            "6, 8, 7, 5",       // only x too high
            "10, 6, 8, 8",      // only y too high
            "70, 6, -3, -6",    // both are negative
            "43, 23, -4, 15",   // x is negative
            "70, 40, 30, -9"    // y is negative
    })
    void shouldReturnFalseWhenInvalidPosition(int boardWidth, int bordHeight, int x, int y) {
        // Given
        ChessPiece piece = new Knight(x, y);

        // When
        boolean result = piece.isValidPosition(
                boardWidth,
                bordHeight,
                piece.getX(),
                piece.getY()
        );

        // Then
        assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource({
            "6, 6, 0, 0",       // lowest both
            "6, 8, 0, 5",       // lowest x
            "10, 6, 8, 0",      // lowest y
            "40, 40, 24, 12",   // in the middle
            "70, 6, 69, 5",     // highest both
            "43, 23, 42, 15",   // highest x
            "70, 40, 30, 24"    // highest y
    })
    void shouldReturnTrueWhenInvalidPosition(int boardWidth, int bordHeight, int x, int y) {
        // Given
        ChessPiece piece = new Knight(x, y);

        // When
        boolean result = piece.isValidPosition(
                boardWidth,
                bordHeight,
                piece.getX(),
                piece.getY()
        );

        // Then
        assertTrue(result);
    }
}
