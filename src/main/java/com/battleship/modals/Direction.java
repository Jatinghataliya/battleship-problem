package com.battleship.modals;

public enum Direction {
	
	VERTICAL("vertical"),
	HORIZONTAL("horizontal");
	
	private final String name;
	
	private Direction(String name) {
		this.name = name;
	}
	
	public boolean equal(String name) {
		return this.name.equals(name);
	}
	
	public String toString() {
		return this.name;
	}
	
}