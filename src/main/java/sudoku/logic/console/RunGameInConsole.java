package sudoku.logic.console;

import sudoku.gui.ConsoleDisplay;
import sudoku.logic.MoveValidation;
import sudoku.logic.SolutionCheck;
import sudoku.model.Cell;
import sudoku.model.Grid;
import sudoku.model.PlayerMove;
import sudoku.model.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class RunGameInConsole {

	public static String cleanInput(String input) {
		String modifiedInput = input.replaceAll("\\s", "");
		return modifiedInput.replaceAll("\\W", "");
	}

	// Class Variables
	private Grid grid;
	private Scanner scanner;
	private String input;
	private String preset;
	
	// Constructor
	public RunGameInConsole(Grid grid, Scanner scanner) {
		this.grid = grid;
		this.scanner = scanner;
		this.input = "";
		this.preset ="";
	}

	public RunGameInConsole(Grid grid, Scanner scanner, String preset){
		this.grid = grid;
		this.scanner = scanner;
		this.input = "";
		this.preset = preset;
	}
	
	
	// Methods
	private void setCellValue(HashMap<String, Integer> move) {
		int x = move.get("X") - 1;
		int y = move.get("Y") - 1;
		
		int value = move.get("Value");
		
		Row row = this.grid.getGrid().get(y);
		Cell cell = row.getRowOfCells().get(x);
		
		cell.setValue(value);
	}

	public void runGame(){
		PlayerMove move;
		boolean keepPlaying = true;
		if(!this.preset.isEmpty()){
			this.grid.createGrid(this.preset);
		}
		if(this.grid.getGridTotal() == 0){
			this.grid.createGrid();
		}

		while(keepPlaying){
			System.out.println(ConsoleDisplay.titleGame());
			ConsoleDisplay.displayGame(this.grid);

			this.input = consoleInputLoop();

			// end game/ break loop
			if(this.input.equals("-1")){
				break;
			}

			if(this.input.equals("c")){
				System.out.println(SolutionCheck.checkSolution(this.grid));
				break;
			}

			// set move
			move = new PlayerMove(this.input);
			setCellValue(move.getMoveMap());
		}

		// Ask user to save grid object
		System.out.print("Do you want to save this board to file? Enter Yes or No ");
		char response = this.scanner.nextLine().toLowerCase().charAt(0);
		if(response == 'y'){
			saveGridToFile();
		}

		System.out.println("Game has ended!");
	}

	private void saveGridToFile(){
		File file = new File("../Collab-Sudoku-Solver/res/sudoku_grid");

		try{
			FileOutputStream out = new FileOutputStream(file);
			ObjectOutputStream outObj = new ObjectOutputStream(out);
			outObj.writeObject(this.grid);
			outObj.close();
			System.out.println("The object was written to file");
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public String consoleInputLoop() {
		boolean keepInputting = true;
		String input = "";

		while(keepInputting) {
			System.out.print(ConsoleDisplay.userPromptAsString());
			input = this.scanner.nextLine();

			if(input.equals("-1")) {
				System.out.println(ConsoleDisplay.endGamePromptString());
				return "-1";
			}

			if(input.toLowerCase().startsWith("c")){
				System.out.println("\nChecking grid...");
				return "c";
			}
			else if(input.toLowerCase().startsWith("c")){
				// add logic for checking board for win
			}
			else{
				input = cleanInput(input);
			}

			if(MoveValidation.inputIsValid(input)) {
				keepInputting = false;
			}
			else{
				System.out.println(ConsoleDisplay.wrongInputString());
			}
		}
		return input;
	}
}
