package com.battleship.modals;


public class Location {
	
	private int row;
	private int column;
	private String terminate;
	private Directions directions;
	
	public Location() {}
	
	public Location(int row, int column, Directions directions) {
		this.row = row;
		this.column = column;
		this.directions = directions;
	}
	
	public int getRow() {
		return row;
	}
	
	public String getTerminate() {
		return terminate;
	}

	public Location setTerminate(String terminate) {
		this.terminate = terminate;
		return this;
	}

	public Location setRow(int row) throws Exception {
		
		if(row > 10 && row < 1) {
			throw new Exception("Invalid row number");
		}
		
		this.row = row;
		return this;
	}
	
	public int getColumn() {
		return column;
	}
	
	public Location setColumn(int column) throws Exception {
		
		if(column > 10 && column < 1) {
			throw new Exception("Invalid row number");
		}
		
		this.column = column;
		return this;
	}
	
	public Directions getDirections() {
		return directions;
	}

	public Location setDirections(Directions directions) {
		this.directions = directions;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
	public boolean isTerminated() {
		
		if(this.terminate == null|| this.terminate.isEmpty()) {
			return false;
		}
		
		return this.terminate.equalsIgnoreCase("I LOSE");
	}
	
	@Override
	public String toString() {
		return "Location [row=" + row + ", column=" + column + ", terminate=" + terminate + "]";
	}

	public String toString(boolean isShipLocation) {
		return isShipLocation ? "Ship Locations  : [row=" + row + ", column=" + column + "]"  : "Hited Location  : [row=" + row + ", column=" + column + "]";
	}
	
}