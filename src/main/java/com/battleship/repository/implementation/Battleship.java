package com.battleship.repository.implementation;

import com.battleship.enums.Status;
import com.battleship.exception.ShipException;
import com.battleship.modals.Location;
import com.battleship.repository.Ship;
import com.battleship.services.FixedSizeMap;

public class Battleship implements Ship {

	private FixedSizeMap hits;
	private static final String TYPE = "Battleship";
	private static final int SIZE = 4;
	
	public Battleship() {
		hits = new FixedSizeMap(getSize());
	}

	@Override
	public boolean isSunk() {
		return hits.getMap().values().stream().allMatch(b -> b.booleanValue());
	}

	@Override
	public int getSize() {
		return SIZE;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public Status hit(Location location) {
		if(isSunk()) {
			return Status.SINK;
		} else {
			Boolean bl =  hits.getMap().getOrDefault(location, null);
			if(bl == null) {
				return Status.MISS;
			} else {
				if(!bl.booleanValue()) {
					hits.put(location, true);
					if(isSunk()) {
						return Status.SINK;
					} else {
						return Status.HIT;
					}
				} else {
					return Status.HITED;
				} 
			}
		}
	}

	@Override
	public boolean setShip(Location location) throws Exception {
		if(hits.put(location, false)) {
			return true;
		} else {
			throw new ShipException(SHIP_SIZE);
		}
	}

	@Override
	public Location getPreviousLocation() {
		return hits.getMap().keySet().stream().reduce((first, second) -> second).orElse(null);
	}
}