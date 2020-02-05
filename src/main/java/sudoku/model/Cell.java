package sudoku.model;

import java.io.Serializable;

public class Cell implements Serializable {

	// Variables 
	private int value;
	
	
	// Constructors
	public Cell(int value){
		this.value = value;
	}

	public Cell(){
		this(0);
	}

	// Getters & Setters

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}


	// Methods
	@Override
	public boolean equals(Object object) {
		if(object == null) {
			return false;
		}

		if(getClass() != object.getClass()) {
			return false;
		}

		Cell compared = (Cell) object;

		if(this.getValue() != compared.getValue()){
			return false;
		}
		return true;
	}

	// review this method more
	@Override
	public String toString() {
		String output = "";

		if(getValue() == 0) {
			output =  " . ";

		} else {
			output = " " + getValue() + " ";
		}
		return output;
	}
}
