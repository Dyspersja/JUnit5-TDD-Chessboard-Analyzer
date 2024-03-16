package com.dyspersja;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ChessboardTest {

    @ParameterizedTest
    @CsvSource({
            "-2, 8",
            "8, -3",
            "2, 8",
            "8, 5",
            "75, 8",
            "8, 45"
    })
    void shouldThrowExceptionWhenBoardsSizeIsInvalid(int width, int height) {
        // Given ...

        // Then
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                // When
                new Chessboard(width, height));

        assertEquals("Invalid Checkerboard size", exception.getMessage());
    }

}