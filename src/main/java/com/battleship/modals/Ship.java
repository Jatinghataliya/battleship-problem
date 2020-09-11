package com.battleship.modals;

public interface Ship {

	boolean isSunk();
	String getType();
	int getSize();
	boolean setShip(Location location) throws Exception;
	Status hit(Location location);
	Location getPreviousLocation();
}
