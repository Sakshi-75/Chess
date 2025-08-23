package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements ChessPiece{
    private final String currentPosition;

    public Pawn(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public List<String> getPossibleMoves() {
        int row = Integer.parseInt(String.valueOf(currentPosition.charAt(1)));
        String column = String.valueOf(currentPosition.charAt(0));
        List<String> positions = new ArrayList<>();
        if (row<8) {
           String newPosition = column + (row + 1);
           positions.add(newPosition);
        }
        return positions;
    }
}
