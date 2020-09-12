package com.battleship.repository;

import com.battleship.constance.LocationExceptions;
import com.battleship.modals.Location;

public interface Directions extends LocationExceptions {

	boolean isDiagonal(Location currentLocation, Location previousLocation);
	
}
