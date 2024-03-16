package com.dyspersja;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessboardTest {

    @Test
    void shouldThrowExceptionWhenBoardsWidthIsNegativeNumber() {
        // Given
        int width = -2;
        int height = 8;

        // Then
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                // When
                new Chessboard(width, height));

        assertEquals("Wrong Checkerboard size", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenBoardsHeightIsNegativeNumber() {
        // Given
        int width = 8;
        int height = -3;

        // Then
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                // When
                new Chessboard(width, height));

        assertEquals("Wrong Checkerboard size", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenBoardsWidthIsTooSmall() {
        // Given
        int width = 2;
        int height = 8;

        // Then
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                // When
                new Chessboard(width, height));

        assertEquals("Wrong Checkerboard size", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenBoardsHeightIsTooSmall() {
        // Given
        int width = 8;
        int height = 5;

        // Then
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                // When
                new Chessboard(width, height));

        assertEquals("Wrong Checkerboard size", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenBoardsWidthIsTooBig() {
        // Given
        int width = 75;
        int height = 8;

        // Then
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                // When
                new Chessboard(width, height));

        assertEquals("Wrong Checkerboard size", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenBoardsHeightIsTooBig() {
        // Given
        int width = 8;
        int height = 45;

        // Then
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                // When
                new Chessboard(width, height));

        assertEquals("Wrong Checkerboard size", exception.getMessage());
    }
}