package org.example.service;

import org.example.model.King;
import org.example.model.Pawn;
import org.example.utils.BoardUtils;

import java.util.List;

public class ChessAppService {
    public static List<String> possiblePositions(String pieceType, String position) throws Exception {
        if(!BoardUtils.isValidPositionOnBoard(position)) {
            throw new Exception("Invalid position");
        }
        switch (pieceType.toLowerCase()) {
            case "pawn": {
                Pawn pawn = new Pawn(position);
                return pawn.getPossibleMoves();
            }
            case "king": {
                King king =new King(position);
                return king.getPossibleMoves();
            }
        }
        return null;
    }

}
