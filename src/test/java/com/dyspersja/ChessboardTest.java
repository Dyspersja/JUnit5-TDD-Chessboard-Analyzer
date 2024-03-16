package com.dyspersja;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ChessboardTest {

    @ParameterizedTest
    @CsvSource({
            "-2, 8",    // negative width
            "8, -3",    // negative height
            "2, 8",     // too small width
            "8, 5",     // too small height
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

}