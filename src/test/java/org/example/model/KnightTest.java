package org.example.model;

import org.example.utils.BoardUtils;
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

    @Test
    void testMovesFromBottomEdge() {
        knight.setCurrentPosition("D1");
        List<String> result = knight.getPossibleMoves();
        List<String> expected = List.of("C3", "E3", "B2", "F2");
        assertNotNull(result);
        assertEquals(4, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testMovesFromTopEdge() {
        knight.setCurrentPosition("E8");
        List<String> result = knight.getPossibleMoves();
        List<String> expected = List.of("D6", "F6", "C7", "G7");
        System.out.println(result);
        assertNotNull(result);
        assertEquals(4, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testMovesFromRightEdge() {
        knight.setCurrentPosition("H4");
        List<String> result = knight.getPossibleMoves();
        List<String> expected = List.of("F5", "F3", "G6", "G2");
        assertNotNull(result);
        assertEquals(4, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testMovesFromOppositeCorner() {
        knight.setCurrentPosition("H8");
        List<String> result = knight.getPossibleMoves();
        List<String> expected = List.of("F7", "G6");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}