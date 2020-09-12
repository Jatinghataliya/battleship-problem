package com.battleship.modals;

import com.battleship.repository.Directions;
import com.battleship.repository.implementation.Horizontal;
import com.battleship.repository.implementation.Patrol;
import com.battleship.repository.implementation.Submarine;
import com.battleship.repository.implementation.Vertical;

public class Game {

	public static void main(String[] args) throws Exception {
		
		Field field = new Field();
		/***********************  Set Field with battle ships **********************/
		Patrol patrol = new Patrol();
		Directions vertical = new Vertical(); 
		field
			.put(new Square().setLocation(new Location().setRow(2).setColumn(3).setDirections(vertical)).setShip(patrol))
			.put(new Square().setLocation(new Location().setRow(2).setColumn(4).setDirections(vertical)).setShip(patrol));
		
		Submarine ship = new Submarine();
		Directions horizontal = new Horizontal();
		field
			.put(new Square().setLocation(new Location().setRow(3).setColumn(3).setDirections(horizontal)).setShip(ship))
			.put(new Square().setLocation(new Location().setRow(4).setColumn(3).setDirections(horizontal)).setShip(ship))
			//.put(new Square().setLocation(new Location().setRow(4).setColumn(4).setDirections(horizontal)).setShip(ship))
			.put(new Square().setLocation(new Location().setRow(5).setColumn(3).setDirections(horizontal)).setShip(ship));
		/***********************  Set Field with battle ships **********************/
		
		/************************* Let's Start Over Game****************************/
		System.out.println(field.hit(new Location().setRow(2).setColumn(3)));
		System.out.println(field.hit(new Location().setRow(2).setColumn(4)));
		System.out.println(field.hit(new Location().setRow(3).setColumn(3)));
		System.out.println(field.hit(new Location().setRow(4).setColumn(3)));
		System.out.println(field.hit(new Location().setRow(5).setColumn(3)));
		System.out.println(field.hit(new Location().setTerminate("I Lose")));
		/************************* Let's Start Over Game****************************/
	}
}