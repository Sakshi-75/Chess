package org.example.model;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class QueenTest {
    Queen queen = new Queen("");

    @Test
    void testMovesFromCenter() {
        queen.setCurrentPosition("E4");
        List<String> expected = Arrays.asList("A8", "B7", "C6", "D5", "F3", "G2", "H1", "B1", "C2", "D3", "F5", "G6", "H7",
                "E8", "E7", "E6", "E5", "E3", "E2", "E1", "A4", "B4", "C4", "D4", "F4", "G4", "H4");
        List<String> result = queen.getPossibleMoves();
        assertNotNull(result);
        assertEquals(expected.size(), result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testMovesFromEdge() {
        queen.setCurrentPosition("A4");
        List<String> expected = Arrays.asList("A8", "A7", "A6", "A5", "A3", "A2", "A1", "B4", "C4", "D4", "E4", "F4", "G4", "H4",
                "B5", "C6", "D7", "E8", "B3", "C2", "D1");
        List<String> result = queen.getPossibleMoves();
        assertNotNull(result);
        assertEquals(expected.size(), result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testMovesFromCorner() {
        queen.setCurrentPosition("A1");
        List<String> expected = Arrays.asList("A8", "A7", "A6", "A5", "A4", "A3", "A2", "B1", "C1", "D1", "E1", "F1", "G1", "H1",
                "B2", "C3", "D4", "E5", "F6", "G7", "H8");
        List<String> result = queen.getPossibleMoves();
        assertNotNull(result);
        assertEquals(expected.size(), result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}