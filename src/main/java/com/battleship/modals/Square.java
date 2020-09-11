package com.battleship.modals;

public class Square {

	private Location location;
	private Ship ship;
	
	public Square() {}
	
	public Square(Location location, Ship ship) {
		super();
		this.location = location;
		this.ship = ship;
	}

	public Location getLocation() {
		return location;
	}
	public Square setLocation(Location location) {
		this.location = location;
		return this;
	}
	public Ship getShip() {
		return ship;
	}
	public Square setShip(Ship ship) {
		this.ship = ship;
		return this;
	}

	@Override
	public String toString() {
		return "Square [location=" + location.toString() + ", ship=" + ship.toString() + "]";
	}
	
	public boolean isDiagonal() {
		
		Location previousLocation = getShip().getPreviousLocation();
		if(previousLocation == null) {
			return false;
		}
		
		if(!previousLocation.getDirection().equals(getLocation().getDirection())) {
			return true;
		}
		
		if(getLocation().getDirection().equals(Direction.HORIZONTAL)) {
			if(previousLocation.getColumn() == getLocation().getColumn() && previousLocation.getRow() != getLocation().getRow()) {
				return  false;
			} else {
				return true;
			}
		}
		
		if(getLocation().getDirection().equals(Direction.VERTICAL)) {
			if(previousLocation.getRow() == getLocation().getRow() && previousLocation.getColumn() != getLocation().getColumn()) {
				return  false;
			} else {
				return true;
			}
		}
		
		return false;
	}
}