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
        int[][] directions = {
                {1, -1},  // diagonal top left
                {1, 1},   // diagonal top right
                {-1, -1}, // diagonal bottom left
                {-1, 1},  // diagonal bottom right
                {1, 0},   // vertical up
                {-1, 0},  // vertical down
                {0, -1},  // horizontal left
                {0, 1}    // horizontal right
        };

        for (int[] dir : directions) {
            int row = currRow;
            int col = currCol;

            while (true) {
                row += dir[0];
                col += dir[1];
                String newPosition = inChessNotation(row, col);

                if (isValidPositionOnBoard(newPosition)) {
                    moves.add(newPosition);
                } else {
                    break;
                }
            }
        }

        return moves;
    }

    @Override
    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }
}
