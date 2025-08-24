package org.example.utils;

public class BoardUtils {
    public static boolean isValidPositionOnBoard(String position) {
        if (position.length()!=2) {
            return false;
        }
        String column = String.valueOf(position.charAt(0));
        String row = String.valueOf(position.charAt(1));
        if (!"12345678".contains(row)) {
            return false;
        }

        if(!"ABCDEFGH".contains(column)) {
            return false;
        }

        return true;
    }

    public static String inChessNotation(int row, int col) {
        return ""+ (char)('A'+col) + (row);
    }
}
