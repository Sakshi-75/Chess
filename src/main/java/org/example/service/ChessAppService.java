package org.example.service;

import org.example.model.Pawn;

import java.util.List;

public class ChessAppService {
    public static List<String> possiblePositions(String pieceType, String position) throws Exception {
        validatePosition(position);
        switch (pieceType.toLowerCase()) {
            case "pawn": {
                Pawn pawn = new Pawn(position);
                return pawn.getPossibleMoves();
            }
        }
        return null;
    }

    private static void validatePosition(String position) throws Exception {
        String column = String.valueOf(position.charAt(0));
        String row = String.valueOf(position.charAt(1));
        if (!"12345678".contains(row)) {
            throw new Exception("Invalid row");
        }

        if(!"ABCDEFGH".contains(column)) {
            throw new Exception("Invalid column");
        }
    }
}
