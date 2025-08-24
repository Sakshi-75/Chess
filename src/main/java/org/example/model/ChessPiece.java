package org.example.model;

import java.util.List;

public interface ChessPiece {
    List<String> getPossibleMoves();
    void setCurrentPosition(String currentPosition);
}
