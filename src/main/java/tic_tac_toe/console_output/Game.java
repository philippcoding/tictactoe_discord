package tic_tac_toe.console_output;

import tic_tac_toe.game_parts.Board;
import tic_tac_toe.game_parts.Player;

public class Game {
    private Board board;

    public Game() {
        this.board = new Board();
    }

    // get input
    private void promptForInput(Player pl) {
        System.out.print(pl.name() + ", please enter your move: ");
        System.out.println("Please enter 'q' to quit.");

    }

    // is input valid
    private boolean isInputValid(String input){
        String modifiedInput = input.replaceAll("\\s\\w", "");
        if(modifiedInput.length() != 2){
            return false;
        }

        if(!Character.isDigit(modifiedInput.charAt(0)) || !Character.isDigit(modifiedInput.charAt(1))){
            return false;
        }

        int xCoordinate = Integer.parseInt(String.valueOf(modifiedInput.charAt(0)));
        if(xCoordinate > 3 || xCoordinate < 1){
            return false;
        }

        int yCoordinate = Integer.parseInt(String.valueOf(modifiedInput.charAt(1)));
        if(yCoordinate > 3 || yCoordinate < 1){
            return false;
        }

        return true;
    }

    // Quit game? Or keep playing
    private boolean keepPlaying(String input){
        if(!input.toLowerCase().startsWith("q")){
            return true;
        }
        else{
            return false;
        }
    }

    public void runGame(){
        boolean stillRunning = true;

        while(stillRunning){

        }
    }
}
