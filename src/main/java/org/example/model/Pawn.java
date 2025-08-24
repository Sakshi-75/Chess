package org.example.model;

import org.example.utils.BoardUtils;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements ChessPiece{
    private String currentPosition;

    public Pawn(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public List<String> getPossibleMoves() {
        int currRow = Character.getNumericValue(currentPosition.charAt(1));
        int currCol = currentPosition.charAt(0) - 'A';
        List<String> positions = new ArrayList<>();
        String newPosition = BoardUtils.inChessNotation(currRow+1, currCol);
        if(BoardUtils.isValidPositionOnBoard(newPosition))
            positions.add(newPosition);
        return positions;
    }

    @Override
    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }
}
