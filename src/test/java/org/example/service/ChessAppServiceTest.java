package org.example.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;

import java.lang.reflect.Array;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void testKingMovesFromD5() throws Exception {
        List<String> result = ChessAppService.possiblePositions("King", "D5");
        List<String> expected = List.of("C6", "D6", "E6", "C5", "E5", "C4", "D4", "E4");
        assertNotNull(result);
        assertEquals(8, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testKingMovesFromLeftEdge() throws Exception {
        List<String> result = ChessAppService.possiblePositions("King", "A5");
        List<String> expected = List.of("A6", "B6", "B5", "A4", "B4");
        assertNotNull(result);
        assertEquals(5, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testKingMovesFromRightEdge() throws Exception {
        List<String> result = ChessAppService.possiblePositions("King", "H5");
        List<String> expected = List.of("H6", "G6", "G5", "H4", "G4");
        assertNotNull(result);
        assertEquals(5, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testKingMovesFromCorner() throws Exception {
        List<String> result = ChessAppService.possiblePositions("King", "A1");
        List<String> expected = List.of("A2", "B2", "B1");
        assertNotNull(result);
        assertEquals(3, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testKnightMovesFromD5() throws Exception {
        List<String> result = ChessAppService.possiblePositions("Knight", "D5");
        List<String> expected = List.of("C7", "E7", "F6", "F4", "C3", "E3", "B4", "B6");
        assertNotNull(result);
        assertEquals(8, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testKnightMovesFromEdge() throws Exception {
        List<String> result = ChessAppService.possiblePositions("Knight", "A5");
        List<String> expected = List.of("B7", "C6", "C4", "B3");
        assertNotNull(result);
        assertEquals(4, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void testKnightMovesFromCorner() throws Exception {
        List<String> result = ChessAppService.possiblePositions("Knight", "A1");
        List<String> expected = List.of("C2", "B3");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

}