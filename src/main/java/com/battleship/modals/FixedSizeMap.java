package com.battleship.modals;

import java.util.LinkedHashMap;
import java.util.Map;

public class FixedSizeMap extends LinkedHashMap<Location, Boolean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3690161834240830953L;

	private int max;
	private Map<Location, Boolean> map;
	
	public FixedSizeMap(int  max) {
		this.max = max;
		map = new LinkedHashMap<Location, Boolean>();
	}
	
	public Boolean put(Location key, Boolean value){
		try {
			if(map.size() <= max) {
				map.put(key, value);
				return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Map<Location, Boolean> getMap(){
		return map;
	}

	@Override
	public String toString() {
		return "FixedSizeMap [max=" + max + ", map=" + map + "]";
	}
}