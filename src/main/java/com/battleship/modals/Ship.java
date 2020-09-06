package com.battleship.modals;

public interface Ship {

	boolean isSunk();
	String getType();
	int getSize();
	Status hit(Location location);
}
