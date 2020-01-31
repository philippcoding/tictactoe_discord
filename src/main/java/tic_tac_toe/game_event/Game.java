package tic_tac_toe.game_event;

import tic_tac_toe.game_parts.Board;

import java.util.Scanner;

public class Game {
    private Board board;
    private Scanner scanner;

    public Game(Scanner scanner) {
        this.board = new Board();
        this.scanner = scanner;
    }

    // get input
    public void getInput() {
        String move = "";
        System.out.print("Please enter your move: ");
        move = this.scanner.nextLine();
    }
}
