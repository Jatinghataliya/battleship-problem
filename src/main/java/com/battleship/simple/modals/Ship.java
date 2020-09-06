package com.battleship.simple.modals;

public interface Ship {

	boolean isSunk();
	String getType();
	int getSize();
	Status hit(Location location);
}
