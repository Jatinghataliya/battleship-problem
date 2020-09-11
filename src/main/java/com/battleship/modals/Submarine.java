package com.battleship.modals;

import java.util.function.Predicate;

public class Submarine implements Ship {

	private FixedSizeMap hits;
	
	public Submarine() {
		hits = new FixedSizeMap(getSize());
	}

	@Override
	public boolean isSunk() {
		return hits.getMap().values().stream().allMatch(new Predicate<Boolean>() {
			@Override
			public boolean test(Boolean t) {
				return t.booleanValue() == true;
			}
		});
	}

	@Override
	public int getSize() {
		return 3;
	}

	@Override
	public String getType() {
		return "Submarine";
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
			throw new Exception("Ship size exceeded`");
		}
	}

	@Override
	public Location getPreviousLocation() {
		try {
			return hits.getMap().keySet().stream().reduce((first, second) -> second).orElse(null);
		} catch(Exception e) {
			e.printStackTrace();
			return  null;
		}
	}
	
}