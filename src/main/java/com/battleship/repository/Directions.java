package com.battleship.repository;

import com.battleship.modals.Location;

public interface Directions {

	boolean isDiagonal(Location currentLocation, Location previousLocation);
	
}
