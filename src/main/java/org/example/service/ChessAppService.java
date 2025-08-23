package org.example.service;

import org.example.model.Pawn;

import java.util.List;

public class ChessAppService {
    public static List<String> possiblePositions(String pieceType, String position) {
        switch (pieceType.toLowerCase()) {
            case "pawn": {
                Pawn pawn = new Pawn(position);
                return pawn.getPossibleMoves();
            }
        }
        return null;
    }
}
