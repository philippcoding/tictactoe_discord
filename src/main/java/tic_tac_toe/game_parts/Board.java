package tic_tac_toe.game_parts;

import java.util.ArrayList;

public class Board {

    private ArrayList<Block> board;

    public Board() {
        this.board = new ArrayList<Block>();
        createBoard();
    }

    private void createBoard() {
        this.board.add(new UpperCenterRow());
        this.board.add(new UpperCenterRow());
        this.board.add(new BottomRow());
    }

    public void setBlock(Player pl, int x, int y) {
        this.board.get(y).setCrossOrNought(pl.toString().charAt(0), x);
    }

    public void displayBoard() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String s = "";
        for(Block b: this.board) {
            s += b.toString();
        }
        return s + "\n";
    }
}
