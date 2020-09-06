package com.battleship.simple.modals;

import java.util.HashMap;
import java.util.Map;

public class FixedSizeMap extends HashMap<Location, Boolean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3690161834240830953L;

	private int max;
	private Map<Location, Boolean> map;
	
	public FixedSizeMap(int  max) {
		this.max = max;
		map = new HashMap<Location, Boolean>();
	}
	
	public Boolean put(Location key, Boolean value){
		if(map.size() <= max) {
			return map.put(key, value);
		} 
		return value;
	}
		
}