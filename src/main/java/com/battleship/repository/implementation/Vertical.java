package com.battleship.repository.implementation;

import com.battleship.exception.LocationException;
import com.battleship.modals.Location;
import com.battleship.repository.Directions;

public class Vertical implements Directions {

	@Override
	public boolean isDiagonal(Location currentLocation,  Location previousLocation) throws LocationException{

		if(currentLocation == null) {
			throw new LocationException("Location not available");
		}
		
		if(previousLocation == null) {
			return false;
		}
		
		if(!currentLocation.getClass().equals(previousLocation.getClass())) {
			return true;
		}
		
		return !(currentLocation.getRow() == previousLocation.getRow() && currentLocation.getColumn() != previousLocation.getColumn());
	}

}
