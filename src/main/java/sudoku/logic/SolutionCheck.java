package sudoku.logic;

import sudoku.model.Cell;
import sudoku.model.Grid;
import sudoku.model.Row;

import java.util.ArrayList;

public class SolutionCheck {


    // If grid total (value of all the cells) is less than (gridSize*1), then that means that the grid is only partially filled, thus
    //      solution fails
    private static boolean isGridFilled(Grid grid){
        return (grid.getGridTotal() < 81);
    }

    // used to verify whether one row/ column (list of Cells) contain the set of 1 - (gridSize)
    private static boolean checkRowOrColContainsSequence(ArrayList<Cell> row){
        Cell cell;
        for(int index=1; index<10; index++){
            cell = new Cell(index);
            if(!row.contains(cell)){
                return false;
            }
        }
        return true;
    }


    // Combines the solution checking methods to produce a string to notify user why solution fails
    public static String checkSolution(Grid grid){
        // check if grid is filled or not
        System.out.println("Check if grid is filled...");
        if(isGridFilled(grid)){
            return "Solution is incorrect! Grid is only partially filled or empty!";
        }

        // check the rows + column
        System.out.println("Checking rows...");
        for(Row r: grid.getGrid()){
            if(!checkRowOrColContainsSequence(r.getRowOfCells())){
                return "Solution is incorrect! A row does not contain the correct sequence";
            }
        }

        for(int index=0; index<9; index++){
            if(!checkRowOrColContainsSequence(grid.getGridColumn(index))){
                return "Solution is incorrect! A column does not contain the correct sequence";
            }
        }
       return ("Solution is correct!");
    }
}
