package org.example.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ChessPieceFactoryTest {

    @ParameterizedTest
    @MethodSource(value = "getChessPieceTypes")
    void testCreateChessPiece(String pieceType, Class<?> expectedClass) throws Exception {
        ChessPiece chessPiece = ChessPieceFactory.createChessPiece(pieceType, "A1");
        assertTrue(expectedClass.isInstance(chessPiece));
    }

    static Stream<Arguments> getChessPieceTypes() {
        return Stream.of(
                Arguments.of("Pawn", Pawn.class),
                Arguments.of("King", King.class),
                Arguments.of("Knight", Knight.class),
                Arguments.of("Queen", Queen.class)
        );
    }

    @Test
    void testInvalidPieceType() {
        assertThrows(Exception.class, () -> ChessPieceFactory.createChessPiece("Dummy", "A1"));
    }
}