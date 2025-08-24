package org.example.model;

import org.example.utils.BoardUtils;

import java.util.ArrayList;
import java.util.List;

public class Knight implements ChessPiece{

    private final String currentPosition;

    public Knight(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    //Knight moves will be 2i-1j, 2i1j, 1i2j, -1i2j, -2i-1j, -2i1j, -1i-2j, 1i-2j
    @Override
    public List<String> getPossibleMoves() {
        List<String> moves = new ArrayList<>();
        int[] newRow = {2, 2, 1, -1, -2, -2, -1, 1};
        int[] newCol = {-1, 1, 2, 2, -1, 1, -2, -2};
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
