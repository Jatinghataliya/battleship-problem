package com.battleship.repository;

import com.battleship.constance.ShipException;
import com.battleship.enums.Status;
import com.battleship.modals.Location;

public interface Ship extends ShipException{

	boolean isSunk();
	String getType();
	int getSize();
	boolean setShip(Location location) throws Exception;
	Status hit(Location location);
	Location getPreviousLocation();
}
