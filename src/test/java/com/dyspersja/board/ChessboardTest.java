package com.dyspersja.board;

import com.dyspersja.pieces.ChessPiece;
import com.dyspersja.pieces.Knight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ChessboardTest {

    @ParameterizedTest
    @CsvSource({
            "-8, -8",   // negative both
            "-2, 8",    // negative width
            "8, -3",    // negative height
            "1, 0",     // too small both
            "2, 8",     // too small width
            "8, 5",     // too small height
            "80, 50",   // too big both
            "75, 8",    // too big width
            "8, 45"     // too big height
    })
    void shouldThrowExceptionWhenBoardsSizeIsInvalid(int width, int height) {
        // Given ...

        // Then
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                // When
                new Chessboard(width, height));

        assertEquals("Invalid Checkerboard size", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "6, 6",     // lowest both
            "6, 8",     // lowest width
            "10, 6",    // lowest height
            "43, 23",   // in the middle
            "70, 40",   // highest both
            "70, 6",    // highest width
            "40, 40"    // highest height
    })
    void shouldNotThrowExceptionWhenValidSize(int width, int height) {
        // Given ...

        // Then
        assertDoesNotThrow(() ->
                // When
                new Chessboard(width, height));
    }

    @Test
    void shouldAssignWidthAndHeightWhenValidSize() {
        // Given
        int width = 8;
        int height = 10;

        // When
        Chessboard chessboard = new Chessboard(width, height);

        // Then
        assertEquals(width, chessboard.getWidth());
        assertEquals(height, chessboard.getHeight());
    }

    @Test
    void shouldCreateBoardWithNonNullTiles() {
        // Given
        int width = 16;
        int height = 23;

        // When
        Chessboard chessboard = new Chessboard(width, height);

        // Then
        assertNotNull(chessboard.getTile(0,0));
        assertNotNull(chessboard.getTile(15,22));
        assertNotNull(chessboard.getTile(6,13));
        assertNotNull(chessboard.getTile(4,22));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, -3",   // negative both
            "-6, 8",    // negative x
            "10, -6",   // negative y
            "16, 23",   // too high both
            "20, 14",   // too high x
            "2, 30",    // too high y
    })
    void shouldThrowExceptionWhenPlaceKnightOutsideOfTheBoard(int xPosition, int yPosition) {
        // Given
        int width = 16;
        int height = 23;
        Chessboard chessboard = new Chessboard(width, height);

        // When
        assertThatThrownBy(() -> chessboard.placeKnight(xPosition,yPosition))
                // Then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Cannot place knight outside of the board");
    }

    @Test
    void shouldPlaceKnightOnTheBoardWhenCorrectPosition() {
        // Given
        int width = 16;
        int height = 23;
        Chessboard chessboard = new Chessboard(width, height);

        int xPosition = 10;
        int yPosition = 13;

        // When
        chessboard.placeKnight(xPosition,yPosition);

        // Then
        ChessPiece piece = chessboard.getTile(xPosition,yPosition).getPiece();
        assertThat(piece).isExactlyInstanceOf(Knight.class);
    }

}