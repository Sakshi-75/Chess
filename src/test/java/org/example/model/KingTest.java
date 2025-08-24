package org.example.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class KingTest {
    King king = new King("");
    @Test
    void testMovesFromD5() {
        king.setCurrentPosition("D5");
        List<String> result = king.getPossibleMoves();
        List<String> expected = List.of("C6", "D6", "E6", "C5", "E5", "C4", "D4", "E4");
        assertNotNull(result);
        assertEquals(8, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testMovesFromLeftEdge() {
        king.setCurrentPosition("A5");
        List<String> result = king.getPossibleMoves();
        List<String> expected = List.of("A6", "B6", "B5", "A4", "B4");
        assertNotNull(result);
        assertEquals(5, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testMovesFromRightEdge() {
        king.setCurrentPosition("H5");
        List<String> result = king.getPossibleMoves();
        List<String> expected = List.of("H6", "G6", "G5", "H4", "G4");
        assertNotNull(result);
        assertEquals(5, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testMovesFromCorner() {
        king.setCurrentPosition("A1");
        List<String> result = king.getPossibleMoves();
        List<String> expected = List.of("A2", "B2", "B1");
        assertNotNull(result);
        assertEquals(3, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

}