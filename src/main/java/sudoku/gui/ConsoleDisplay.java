package sudoku.gui;

import sudoku.model.Cell;
import sudoku.model.Grid;
import sudoku.model.Row;

public class ConsoleDisplay {

    // Methods to set Game messages
    public static String titleGame(){
        return "Sudoku Game\n" + "-----------------------------";
    }
    public static String userPromptAsString(){
        return "Game input must be 3 values in this format: (x,y value) \nEnter -1 to quit \nEnter \"check\" to check your board \nEnter your move: ";
    }

    public static String endGamePromptString(){
        return "\nGame has ended!\n";
    }

    public static String wrongInputString(){
        return "Error! Please enter move according to the right format \n";
    }


    // Methods to create string representation of sudoku board
    private static String cellAsString(Cell cell){
        return (cell.getValue() == 0) ? (" . ") : (" " + cell.getValue() + " ");
    }

    private static String rowAsString(Row row){
        String rowString = "";
        for(int index=0; index<row.getRowOfCells().size(); index++){
            Cell cell = row.getRowOfCells().get(index);
            rowString += ((index+1) % 3 == 0) ? (cellAsString(cell) + " ") : (cellAsString(cell));
        }
        return rowString;
    }

    private static String gridAsString(Grid grid){
        String gridString = "";
        int counter = 1;
        for(Row row: grid.getGrid()){
            gridString += (counter % 3 == 0) ? (rowAsString(row) + "\n\n") : (rowAsString(row) + "\n");
            counter++;
        }
        return gridString;
    }

    // Method to display Game in console
    public static void displayGame(Grid grid){
        System.out.println(gridAsString(grid));
    }
}
