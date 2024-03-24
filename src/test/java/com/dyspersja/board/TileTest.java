package com.dyspersja.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TileTest {

    @Test
    void shouldInitializeWithCorrectValues() {
        // Given ...

        // When
        Tile tile = new Tile();

        // Then
        assertEquals(0, tile.getAttackedBy());
        assertNull(tile.getPiece());
    }
}
