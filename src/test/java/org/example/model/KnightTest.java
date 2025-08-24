package org.example.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    Knight knight = new Knight("");

    @Test
    void testMovesFromD5() {
        knight.setCurrentPosition("D5");
        List<String> result = knight.getPossibleMoves();
        List<String> expected = List.of("C7", "E7", "F6", "F4", "C3", "E3", "B4", "B6");
        assertNotNull(result);
        assertEquals(8, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testMovesFromEdge() {
        knight.setCurrentPosition("A5");
        List<String> result = knight.getPossibleMoves();
        List<String> expected = List.of("B7", "C6", "C4", "B3");
        assertNotNull(result);
        assertEquals(4, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testMovesFromCorner() {
        knight.setCurrentPosition("A1");
        List<String> result = knight.getPossibleMoves();
        List<String> expected = List.of("C2", "B3");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

}