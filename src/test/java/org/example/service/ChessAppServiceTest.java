package org.example.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChessAppServiceTest {

    @Test
    void testPawnMovesFromA1() {
        List<String> result = ChessAppService.possiblePositions("Pawn", "A1");
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("A2", result.get(0));
    }
}