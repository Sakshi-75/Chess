package org.example.model;

import org.example.utils.BoardUtils;

import java.util.ArrayList;
import java.util.List;

import static org.example.utils.BoardUtils.inChessNotation;
import static org.example.utils.BoardUtils.isValidPositionOnBoard;

public class Queen implements ChessPiece{
    private String currentPosition;

    public Queen(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public List<String> getPossibleMoves() {
        List<String> moves = new ArrayList<>();
        int currRow = Character.getNumericValue(currentPosition.charAt(1));
        int currCol = currentPosition.charAt(0) - 'A';
        //diagonal top left
        int move = 1;
        while (true) {
            int newRow = currRow + move;
            int newCol = currCol - move;
            String newPosition = inChessNotation(newRow, newCol);
            if(isValidPositionOnBoard(newPosition)) {
                moves.add(newPosition);
                move++;
            }
            else
                break;
        }
        //diagonal top right
        move = 1;
        while (true) {
            int newRow = currRow + move;
            int newCol = currCol + move;
            String newPosition = inChessNotation(newRow, newCol);
            if(isValidPositionOnBoard(newPosition)) {
                moves.add(newPosition);
                move++;
            }
            else
                break;
        }
        //diagonal bottom left
        move = 1;
        while (true) {
            int newRow = currRow - move;
            int newCol = currCol - move;
            String newPosition = inChessNotation(newRow, newCol);
            if(isValidPositionOnBoard(newPosition)) {
                moves.add(newPosition);
                move++;
            }
            else
                break;
        }
        //diagonal bottom right
        move = 1;
        while (true) {
            int newRow = currRow - move;
            int newCol = currCol + move;
            String newPosition = inChessNotation(newRow, newCol);
            if(isValidPositionOnBoard(newPosition)) {
                moves.add(newPosition);
                move++;
            }
            else
                break;
        }

        //vertical
        for (int i=1; i<=8; i++) {
            String newPosition = inChessNotation(i, currCol);
            if(newPosition.equals(currentPosition))
                continue;
            moves.add(newPosition);
        }

        //horizontal
        for (int i=0; i<8; i++) {
            String newPosition = inChessNotation(currRow, i);
            if(newPosition.equals(currentPosition))
                continue;
            moves.add(newPosition);
        }

        return moves;
    }

    @Override
    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }
}
