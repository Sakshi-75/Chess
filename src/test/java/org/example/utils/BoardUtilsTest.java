package org.example.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BoardUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"A5", "H8", "B3", "A1", "H1", "A8"})
    void testValidPosition(String position) {
        assertTrue(BoardUtils.isValidPositionOnBoard(position));
    }

    @ParameterizedTest
    @ValueSource(strings = {"A9","Z5", "B0", "I3", "B10", "C", ""})
    void testInvalidPosition(String position) {
        assertFalse(BoardUtils.isValidPositionOnBoard(position));
    }
}