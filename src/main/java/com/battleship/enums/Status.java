package com.battleship.enums;

public enum Status {

	HIT("HIT"),
	HITED("HITED"),
	FINISH(""),
	MISS("MISS"),
	SINK("SINK");
	
	private final String name;
	
	private Status(String name) {
		this.name = name;
	}
	
	public boolean equal(String name) {
		return this.name.equals(name);
	}
	
	public String toString() {
		return this.name;
	}
}