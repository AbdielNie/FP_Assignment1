package model;

import java.util.Random;

import model.interfaces.DicePair;
import model.interfaces.Die;

public class DicePairImpl implements DicePair {

	private static Random rand = new Random();
	private Die die1;
	private Die die2;
	
	/**
	 * random
	 */
	public DicePairImpl() {
		die1 = new DieImpl(1, rand.nextInt(DieImpl.NUM_FACES) + 1, DieImpl.NUM_FACES);
		die2 = new DieImpl(2, rand.nextInt(DieImpl.NUM_FACES) + 1, DieImpl.NUM_FACES);
	}
	
	
	@Override
	public Die getDie1() {
		return die1;
	}

	@Override
	public Die getDie2() {
		return die2;
	}

	@Override
	public int getTotal() {
		return getDie1().getValue() + getDie2().getValue();
	}

	@Override
	public boolean equals(DicePair dicePair) {
		return die1.equals(dicePair.getDie1()) 
				&& die2.equals(dicePair.getDie2());
	}
	
	@Override
	public boolean equals(Object dicePair) {
		if (dicePair instanceof DicePair) {
			return this.equals((DicePair) dicePair);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return die1.hashCode() * DieImpl.NUM_FACES + die2.hashCode();
	}

	@Override
	public int compareTo(DicePair dicePair) {
		Integer current = getTotal();
		return current.compareTo(dicePair.getTotal());
	}
	
	@Override
	public String toString() {
		return die1.toString() + ", " + die2.toString()
				+ ", Total: " + getTotal();
	}

}
