package model;

import model.interfaces.Die;

public class DieImpl implements Die {
	
	public static final int NUM_FACES = 6;
	private int number;
	private int value;
	private int numFaces;
	
	/**
	 * 
	 * @param number - the number of this die in a pair (i.e. die 1 or 2)
 	 * @param value - the face value of this die as it rolls (between 1 .. numFaces)
 	 * @param numFaces - the number of faces of this die (i.e. the maximum value)
 	 * @throws IllegalArgumentException if: 
 	 * number < 1 || > 2 
 	 * || value is < 1 || value > numFaces 
 	 * || numFaces < 1
	 */
	public DieImpl(int number, int value, int numFaces) throws IllegalArgumentException {
		if (number < 1 || number > 2 
				|| value < 1 || value > numFaces 
				|| numFaces < 1) {
			throw new IllegalArgumentException();
		}
		this.number = number;
		this.value = value;
		this.numFaces = numFaces;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public int getNumFaces() {
		return numFaces;
	}

	@Override
	public boolean equals(Die die) {
		return die.getNumFaces() == getNumFaces() &&
				die.getValue() == getValue();
	}

	@Override
	public boolean equals(Object die) {
		if (die instanceof Die) {
			return this.equals((Die)die);
		}
		return false;
	}
	
	public int hashCode() {
		return getValue() * NUM_FACES + getNumFaces();
	}
	
	@Override
	public String toString() {
		String[] str = {"One", "Two", "Three", "Four", "Five", "Six", 
				"Seven", "Eight", "Nine", "> Nine"};
		if (value < 10) return "Dice " + number + ": " + str[value - 1];
		return "Dice " + number + ": " + str[9];
	}
	
}
