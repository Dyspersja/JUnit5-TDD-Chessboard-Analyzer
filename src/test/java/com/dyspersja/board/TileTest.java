package com.dyspersja.board;

import com.dyspersja.pieces.Knight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void shouldIncrementAttackedByValue() {
        // Given
        int initialAttackedBy = 2;

        Tile tile = new Tile();
        tile.setAttackedBy(initialAttackedBy);

        // When
        tile.incrementAttackedBy();

        // Then
        assertEquals(3, tile.getAttackedBy());
    }

    @Test
    void shouldReturnKnightIfKnightStandsOnATile() {
        // Given
        Tile tile = new Tile();
        tile.setPiece(new Knight(0,0));

        // When
        String result = tile.toString();

        // Then
        assertEquals("\u265E", result);
        assertEquals("♞", result);
    }

    @Test
    void shouldReturnAttackedByValueIfNothingStandsOnATile() {
        // Given
        int initialAttackedBy = 2;

        Tile tile = new Tile();
        tile.setAttackedBy(initialAttackedBy);

        // When
        String result = tile.toString();

        // Then
        assertEquals("2", result);
    }

    @Test
    void shouldReturnTrueWhenTileIsOccupied() {
        // Given
        Tile tile = new Tile();
        tile.setPiece(new Knight(0,0));

        // When
        boolean result = tile.isOccupied();

        // Then
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenTileIsNotOccupied() {
        // Given
        Tile tile = new Tile();

        // When
        boolean result = tile.isOccupied();

        // Then
        assertFalse(result);
    }

}
