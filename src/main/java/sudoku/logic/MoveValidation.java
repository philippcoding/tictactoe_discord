package sudoku.logic;

import static sudoku.logic.console.RunGameInConsole.cleanInput;

// This class checks if user made valid input
public class MoveValidation {

    public MoveValidation(String input){
        input = cleanInput(input);
    }

    public static boolean inputIsValid(String input) {
        if(inputIsCorrectLength(input) && inputsAreIntegers(input) && inputsAreInRange(input)) {
            return true;
        }
        return false;
    }

    // Input validation methods
    private static boolean inputIsCorrectLength(String input) {
        return input.length() == 3;
    }

    private static boolean validateRange(int num) {
        return (num >=0) && (num<=9);
    }

    private static boolean inputsAreIntegers(String input) {
        boolean charIsInteger;
        for(int index = 0; index < input.length(); index++) {
            charIsInteger = Character.isDigit(input.charAt(index));
            if(!charIsInteger) {
                return false;
            }
        }
        return true;
    }

    private static boolean inputsAreInRange(String input) {

        for(int index = 0; index < input.length(); index++) {
            int number = Integer.parseInt(input.charAt(index) + "");
            if(!validateRange(number)){
                return false;
            }
        }
        return true;
    }

}
