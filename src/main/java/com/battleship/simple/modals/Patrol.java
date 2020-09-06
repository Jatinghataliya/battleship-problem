package com.battleship.simple.modals;

import java.util.Map;
import java.util.function.Predicate;

public class Patrol implements Ship {

	private Map<Location, Boolean> hits = new FixedSizeMap(getSize());
	
	@Override
	public boolean isSunk() {
		return hits.values().stream().allMatch(new Predicate<Boolean>() {
			@Override
			public boolean test(Boolean t) {
				return t.booleanValue() == true;
			}
		});
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getType() {
		return "Patrol";
	}

	@Override
	public Status hit(Location location) {
		if(isSunk()) {
			return Status.SINK;
		} else {
			Boolean bl =  hits.getOrDefault(location, null);
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

}