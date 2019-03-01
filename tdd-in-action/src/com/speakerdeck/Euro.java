package com.speakerdeck;

public class Euro {

	private static final double CENTS_PER_EURO = 100;

	private int amount;

	public Euro(double amount) {
		this.amount = (int) (amount * CENTS_PER_EURO);
	}

	public Euro minus(Euro subtrahend) {
		Euro result = new Euro(0);
		result.amount = this.amount - subtrahend.amount;
		return result;
	}

	@Override
	public String toString() {
		return String.format("EURO %.2f", amount / CENTS_PER_EURO);
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Euro && this.amount == ((Euro) o).amount;
	}

}
