package com.battleship.repository.implementation;

import com.battleship.exception.LocationException;
import com.battleship.modals.Location;
import com.battleship.repository.Directions;

public class Horizontal implements Directions {

	@Override
	public boolean isDiagonal(Location currentLocation, Location previousLocation) throws LocationException {
		
		if(currentLocation == null) {
			throw new LocationException(LOCATION_NOT_FOUND);
		}
		
		if(previousLocation == null) {
			return false;
		}
		
		if(!currentLocation.getClass().equals(previousLocation.getClass())) {
			return true;
		}
		
		return !(currentLocation.getColumn() == previousLocation.getColumn() && currentLocation.getRow() != previousLocation.getRow());
	}

}
