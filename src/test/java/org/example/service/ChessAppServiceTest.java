package org.example.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ChessAppServiceTest {

    @Test
    void testInvalidColumnValue() {
        assertThrows(Exception.class, ()-> ChessAppService.possiblePositions("Pawn", "A9"));
    }

    @Test
    void testInvalidRowValue() {
        assertThrows(Exception.class, ()-> ChessAppService.possiblePositions("Pawn", "Z5"));
    }

    @Test
    void testValidPosition() {
        assertDoesNotThrow(() -> ChessAppService.possiblePositions("Pawn", "A3"));
    }

}