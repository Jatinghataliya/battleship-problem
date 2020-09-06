package com.battleship.modals;

import java.util.ArrayList;
import java.util.List;

public class Field {

	private Square[][] squares;
	private List<Location> locations = new ArrayList<Location>();
	private final static int BOARD_ROW = 10, BOARD_COLUMN = 10;
	
	public Field() {
		squares = new Square[BOARD_ROW][BOARD_COLUMN];
	}

	public Square[][] getSquares() {
		return squares;
	}
	
	public Field putSquare(Square square) throws Exception {
		Location location = square.getLocation();
		Square square2 = squares[location.getRow()][location.getColumn()];
		if(square2 == null) {
			if(isNotDiagonalElement(location)) {
				squares[location.getRow()][location.getColumn()] = square;
			}
		} else {
			throw new Exception("Battleship already located to this location");
		}
		return this;
	}
	
	private Square getSquare(Location location) throws Exception {
		
		if(squares == null) {
			throw new Exception("Battle Field not setup");
		}
		
		return squares[location.getRow()][location.getColumn()];
		
	}
	
	public String hit(Location location) throws Exception {
		
		if(location.isTerminated()) {
			
			printBoard();
			printShot();
			return location.getStatus(Status.FINISH);
			
		} else {
			
			locations.add(location);
			Square square = getSquare(location);
			
			if(square == null) {
				return location.getStatus(Status.MISS);
			}
			
			return location.getStatus(square.getShip().hit(location));
		}
	}
	
	private void printShot() {
		locations.stream().forEach(location -> location.toString(false));
	}
	
	private void printBoard() {
		for (Square[] squares : this.squares) {
			for(Square square : squares) {
				if(square != null) {
					System.out.println(square.getLocation().toString(true));
				}
			}
		}
	}
	
	private boolean isNotDiagonalElement(Location location) {
		int i, j;
		 /* Check this row on left side */
        for (i = 0; i < location.getRow(); i++)
            if (squares[i][location.getColumn()] != null)
                return false;

        /* Check upper diagonal on left side */
        for (i= location.getRow(), j = location.getColumn(); i>=0 && j>=0; i--, j--)
            if (squares[i][j] != null)
                return false;

        /* Check lower diagonal on left side */
        for (i=location.getRow(), j=location.getColumn(); j>=0 && i<squares.length; i++, j--)
            if (squares[i][j] != null)
                return false;

        return true;
			
	}
}