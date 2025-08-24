package org.example;

import org.example.service.ChessAppService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChessAppTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUpStreams() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void testValidInputScenario() {
        try (MockedStatic<ChessAppService> mockedChessAppService = Mockito.mockStatic(ChessAppService.class)){
            String userInput = "Pawn, E4";
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            mockedChessAppService.when(() -> ChessAppService.possiblePositions("Pawn", "E4"))
                    .thenReturn(List.of("E5"));
            ChessApp.main(new String[]{});
            String consoleOutput = outputStream.toString();
            assertTrue(consoleOutput.contains("[E5]"));
        }
    }

    @Test
    void testInvalidPieceTypeScenario() {
        try (MockedStatic<ChessAppService> mockedChessAppService = Mockito.mockStatic(ChessAppService.class)) {
            String userInput = "Dummy, E4";
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            mockedChessAppService.when(() -> ChessAppService.possiblePositions("Dummy", "E4"))
                    .thenThrow(new Exception("Invalid piece type"));
            ChessApp.main(new String[]{});
            String consoleOutput = outputStream.toString();
            assertTrue(consoleOutput.contains("Invalid piece type"));
        }
    }

    @Test
    void testInvalidPositionScenario() {
        try (MockedStatic<ChessAppService> mockedChessAppService = Mockito.mockStatic(ChessAppService.class)) {
            String userInput = "Pawn, E9";
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            mockedChessAppService.when(() -> ChessAppService.possiblePositions("Pawn", "E9"))
                    .thenThrow(new Exception("Invalid position"));
            ChessApp.main(new String[]{});
            String consoleOutput = outputStream.toString();
            assertTrue(consoleOutput.contains("Invalid position"));
        }
    }

    @Test
    void testInvalidInputFormatScenario() {
        String userInput = "Pawn E5";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        ChessApp.main(new String[]{});
        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("Invalid input format"));
    }

}