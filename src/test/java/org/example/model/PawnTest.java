package org.example.model;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class PawnTest {
    Pawn pawn = new Pawn("");

    @Test
    void testMovesFromA1() {
        pawn.setCurrentPosition("A1");
        List<String> result = pawn.getPossibleMoves();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("A2", result.get(0));
    }

    @Test
    void testMovesFromA8() {
        pawn.setCurrentPosition("A8");
        List<String> result = pawn.getPossibleMoves();
        assertNotNull(result);
        assertEquals(0, result.size());
    }
}