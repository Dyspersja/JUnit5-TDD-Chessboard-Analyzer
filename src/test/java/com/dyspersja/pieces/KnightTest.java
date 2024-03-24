package com.dyspersja.pieces;

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
}
