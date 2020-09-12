package com.battleship.modals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.battleship.constance.FieldExcecptions;
import com.battleship.enums.Status;
import com.battleship.exception.FieldExcecption;

public class Field implements FieldExcecptions{

	private Square[][] squares;
	private List<Location> locations = new ArrayList<Location>();
	private final static int BOARD_ROW = 10, BOARD_COLUMN = 10;
	
	public Field() {
		squares = new Square[BOARD_ROW][BOARD_COLUMN];
	}

	public Field put(Square square) throws Exception {
		Location location = square.getLocation();
		Square square2 = squares[location.getRow()][location.getColumn()];
		if(square2 == null) {
			if (!square.isDiagonal()) {
				square.getShip().setShip(location);
				squares[location.getRow()][location.getColumn()] = square;
			} else {
				throw new FieldExcecption(IS_DIAGONALLY);
			}
		} else {
			throw new FieldExcecption(BATTLESHIP_LOCATED);
		}
		return this;
	}
	
	public Field pop(Square square) throws Exception {
		Location location = square.getLocation();
		Square square2 = getSquare(location);
		if(square2 != null) {
			squares[location.getRow()][location.getColumn()] = null;
		} else {
			throw new FieldExcecption(SHIP_NOT_FOUND);
		}
		return this;
	}
	
	public String hit(Location location) throws Exception {
		if(location.isTerminated()) {
			printBoard();
			printShot();
			return Status.FINISH.toString();
		} else {
			locations.add(location);
			Square square = getSquare(location);
			if(square == null) {
				return Status.MISS.toString();
			}
			return square.getShip().hit(location).toString();
		}
	}
	
	private void printShot() {
		locations.stream().forEach(location -> System.out.println(location.toString(false)));
	}

	private Square getSquare(Location location) throws Exception {
		if(squares == null) {
			throw new FieldExcecption(FIELD_NOT_FOUND);
		}
		return squares[location.getRow()][location.getColumn()];
	}
	
	private void printBoard() {
		Arrays.stream(this.squares).flatMap(s -> Arrays.stream(s)).filter(s -> s != null).forEach(s -> System.out.println(s.getLocation().toString(true)));
	}
	
}