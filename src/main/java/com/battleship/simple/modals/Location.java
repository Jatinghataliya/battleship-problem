package com.battleship.simple.modals;


public class Location {
	
	private int row;
	private int column;
	private String terminate;
	
	public Location() {
	}
	
	public Location(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}
	
	public String getTerminate() {
		return terminate;
	}

	public void setTerminate(String terminate) {
		this.terminate = terminate;
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
		
		if(this.terminate.isEmpty() || this.terminate == null) {
			return false;
		}
		
		return this.terminate.equalsIgnoreCase("I LOSE");
	}

	public String toString(boolean isShipLocation) {
		return isShipLocation ? "Ship Locations  : [row=" + row + ", column=" + column + "]"  : "Hited Location  : [row=" + row + ", column=" + column + "]";
	}
	
	public String getStatus(Status status) {
		if(status.compareTo(Status.FINISH) == 1) {
			return "Finish";
		} else if(status.compareTo(Status.HIT) == 1) {
			return "Hit";
		} else if(status.compareTo(Status.MISS) == 1) {
			return "Miss";
		} else if(status.compareTo(Status.SINK) == 1) {
			return "Sink";
		} else if(status.compareTo(Status.HITED) == 1) {
			return "Hit";
		} else {
			return "";
		}
	}
}