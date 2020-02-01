package tic_tac_toe.console_output;

import tic_tac_toe.game_parts.Board;
import tic_tac_toe.game_parts.Player;

public class ConsoleApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Board grid = new Board();
        grid.setBlock(Player.X, 1, 1);
        System.out.println(grid);
    }
}
