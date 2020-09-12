package com.battleship.modals;

public class Square {

	private Location location;
	private Ship ship;
	
	public Square() {}
	
	public Square(Location location, Ship ship) {
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
		return getLocation().getDirections().isDiagonal(getLocation(), getShip().getPreviousLocation());
	}
}