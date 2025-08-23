package org.example;

import org.example.service.ChessAppService;
import java.util.Scanner;

public class ChessApp {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please mention the type of chess piece and its position:");
        String[] userInput = scanner.nextLine().split(",");
        String pieceType = userInput[0];
        String position = userInput[1].trim();
        System.out.println(ChessAppService.possiblePositions(pieceType, position));
    }

}