package com.dyspersja.pieces;

import org.junit.jupiter.api.Test;

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

}
