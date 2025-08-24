package org.example;

import org.example.service.ChessAppService;
import java.util.Scanner;

public class ChessApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please mention the type of chess piece and its position:");
        try {
            String pieceType = null;
            String position = null;
            try {
                String[] userInput = scanner.nextLine().split(",");
                pieceType = userInput[0];
                position = userInput[1].trim();
            } catch (Exception e) {
                throw new Exception("Invalid input format");
            }
            System.out.println(ChessAppService.possiblePositions(pieceType, position));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}