package org.example.model;

public class ChessPieceFactory {
    public static ChessPiece createChessPiece(String pieceType, String position) throws Exception {
        return switch (pieceType.toLowerCase()) {
            case "pawn" -> new Pawn(position);
            case "king" -> new King(position);
            case "knight" -> new Knight(position);
            default -> throw new Exception("Invalid piece type");
        };
    }
}
