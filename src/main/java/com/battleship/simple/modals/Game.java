package com.battleship.simple.modals;

public class Game {

	public static void main(String[] args) throws Exception {
		
		Field field = new Field();
		/***********************  Set Field with battle ships **********************/
		Patrol patrol = new Patrol();
		Location location = new Location().setRow(2).setColumn(3);
		Location location2 = new Location().setRow(2).setColumn(4);
		field.putSquare(new Square().setLocation(location2).setShip(patrol)).putSquare(new Square().setLocation(location).setShip(patrol));
		
		Ship ship = new Submarine();
		Square square3 = new Square().setLocation(new Location().setRow(3).setColumn(3)).setShip(ship);
		Square square4 = new Square().setLocation(new Location().setRow(4).setColumn(3)).setShip(ship);
		Square square5 = new Square().setLocation(new Location().setRow(5).setColumn(3)).setShip(ship);
		
		field.putSquare(square3).putSquare(square4).putSquare(square5);
		/***********************  Set Field with battle ships **********************/
		
		/************************* Let's Start Over Game****************************/
		field.hit(location);
		field.hit(location2);
		/************************* Let's Start Over Game****************************/
		
	}
}