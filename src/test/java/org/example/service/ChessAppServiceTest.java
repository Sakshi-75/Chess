package org.example.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChessAppServiceTest {

    @Test
    void testPawnMovesFromA1() throws Exception {
        List<String> result = ChessAppService.possiblePositions("Pawn", "A1");
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("A2", result.get(0));
    }

    @Test
    void testPawnMovesFromA8() throws Exception {
        List<String> result = ChessAppService.possiblePositions("Pawn", "A8");
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void invalidColumnValue() {
        Assertions.assertThrows(Exception.class, ()-> ChessAppService.possiblePositions("Pawn", "A9"));
    }

    @Test
    void invalidRowValue() {
        Assertions.assertThrows(Exception.class, ()-> ChessAppService.possiblePositions("Pawn", "Z5"));
    }

}