package com.battleship.modals;

public class Horizontal implements Directions {

	@Override
	public boolean isDiagonal(Location currentLocation, Location previousLocation) {
		if(previousLocation == null) {
			return false;
		}
		
		if(!currentLocation.getClass().equals(previousLocation.getClass())) {
			return true;
		}
		
		return !(currentLocation.getColumn() == previousLocation.getColumn() && currentLocation.getRow() != previousLocation.getRow());
	}

}
