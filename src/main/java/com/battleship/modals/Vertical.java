package com.battleship.modals;

public class Vertical implements Directions {

	@Override
	public boolean isDiagonal(Location currentLocation,  Location previousLocation) {
		
		if(previousLocation == null) {
			return false;
		}
		
		if(!currentLocation.getClass().equals(previousLocation.getClass())) {
			return true;
		}
		
		return !(currentLocation.getRow() == previousLocation.getRow() && currentLocation.getColumn() != previousLocation.getColumn());
	}

}
