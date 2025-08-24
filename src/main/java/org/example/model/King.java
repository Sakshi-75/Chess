package org.example.model;

import org.example.utils.BoardUtils;

import java.util.ArrayList;
import java.util.List;

public class King implements ChessPiece{
    private final String currentPosition;

    public King(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    //King moves will be -1i-1j, -1i0j, -1i+1j, 0i-1j, 0i+1j, +1i-1j, +1i0j, +1i+1j
    @Override
    public List<String> getPossibleMoves() {
        List<String> moves = new ArrayList<>();
        int[] newRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] newCol = {-1, 0, 1, -1, 1, -1, 0, 1};
        int currRow = Character.getNumericValue(currentPosition.charAt(1));
        int currCol = currentPosition.charAt(0) - 'A';
        for(int i=0; i<8; i++) {
            newRow[i]+=currRow;
            newCol[i]+=currCol;
            String newPosition = ""+ (char)('A'+newCol[i]) + (newRow[i]);
            if(BoardUtils.isValidPositionOnBoard(newPosition)) {
                moves.add(newPosition);
            }
        }
        return moves;
    }
}
