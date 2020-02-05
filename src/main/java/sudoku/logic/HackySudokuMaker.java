package sudoku.logic;

// Retrieve sudoku samples randomly from txt files (one sample, one file)
// method to take sample, replace 81-17 characters with 0, and return the sample


import sudoku.logic.console.RunGameInConsole;

import java.util.Random;

public class HackySudokuMaker {

    public HackySudokuMaker(){
    }

    public static String createPuzzle(){
        String sample = "7\t2\t6\t4\t9\t3\t8\t1\t5\n" +
                "3\t1\t5\t7\t2\t8\t9\t4\t6\n" +
                "4\t8\t9\t6\t5\t1\t2\t3\t7\n" +
                "8\t5\t2\t1\t4\t7\t6\t9\t3\n" +
                "6\t7\t3\t9\t8\t5\t1\t2\t4\n" +
                "9\t4\t1\t3\t6\t2\t7\t5\t8\n" +
                "1\t9\t4\t8\t3\t6\t5\t7\t2\n" +
                "5\t6\t7\t2\t1\t4\t3\t8\t9\n" +
                "2\t3\t8\t5\t7\t9\t4\t6\t1\n";
        StringBuilder sampleCleaned = new StringBuilder(RunGameInConsole.cleanInput(sample));
        Random num = new Random();
        for(int index=0; index<81; index++){
            int indexRand = num.nextInt(81);
            sampleCleaned.setCharAt(indexRand, '0');
        }
        return sampleCleaned.toString();
    }

    //private static String
}
