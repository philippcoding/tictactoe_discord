package sudoku.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Grid implements Serializable {
	
	// Variables
	private ArrayList<Row> gridRows;
	private int gridSize;
	
	
	// Constructors
	public Grid(int gridSize) {
		this.gridSize = gridSize;
		this.gridRows = new ArrayList<>();
	} 
	
	
	// Methods
	public void createGrid() {
		for(int yCoordinateIndex = 0; yCoordinateIndex < this.gridSize; yCoordinateIndex++) {
			Row newRow = new Row();

			for(int xCoordinateIndex = 0; xCoordinateIndex < this.gridSize; xCoordinateIndex++) {
				Cell newCell = new Cell(0);
				newRow.addCellToRow(newCell);
			}

			this.gridRows.add(newRow);
		}
	}

	public void createGrid(String sample){
		//sample = sample.replaceAll("\\s", "");
		int counter = 0;
		for(int yCoordinateIndex = 0; yCoordinateIndex < this.gridSize; yCoordinateIndex++) {
			Row newRow = new Row();

			for(int xCoordinateIndex = 0; xCoordinateIndex < this.gridSize; xCoordinateIndex++) {
				Cell newCell = new Cell(Character.getNumericValue(sample.charAt(counter)));
				newRow.addCellToRow(newCell);
				counter++;
			}

			this.gridRows.add(newRow);
		}
	}

	// Getters and Setters
	public int getGridSize() {
		return gridSize;
	}

	public Cell getCellFromGrid(int coordinateX, int coordinateY) {
		return this.gridRows.get(coordinateY).getRowOfCells().get(coordinateX);
	}

	public Row getGridRow(int rowNumber){
		return this.gridRows.get(rowNumber);
	}

	public ArrayList<Cell> getGridColumn(int columnNumber){
		ArrayList<Cell> column = new ArrayList<>();
		for(Row r: this.gridRows){
			column.add(r.getRowOfCells().get(columnNumber));
		}
		return column;
	}

	public ArrayList<Row> getGrid(){
		return this.gridRows;
	}

	public int getGridTotal(){
		int total = 0;
		for(Row row: this.gridRows){
			total += row.getRowTotal();
		}

		return total;
	}

}
