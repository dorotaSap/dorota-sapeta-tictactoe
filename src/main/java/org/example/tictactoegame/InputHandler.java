package org.example.tictactoegame;

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int getPlayerMove() {
        System.out.println("Podaj numer pola (1-9): ");
        return scanner.nextInt();
    }

    public int getGameMode() {
        System.out.println("Wybierz tryb gry:");
        System.out.println("1. Klasyczny 3x3");
        System.out.println("2. Alternatywny 10x10");
        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }
}
