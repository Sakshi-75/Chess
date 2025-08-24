package org.example.service;

import org.example.model.*;
import org.example.utils.BoardUtils;

import java.util.List;

public class ChessAppService {
    public static List<String> possiblePositions(String pieceType, String position) throws Exception {
        position = position.toUpperCase();
        if(!BoardUtils.isValidPositionOnBoard(position)) {
            throw new Exception("Invalid position");
        }
        ChessPiece chessPiece = ChessPieceFactory.createChessPiece(pieceType, position);
        return chessPiece.getPossibleMoves();
    }

}
