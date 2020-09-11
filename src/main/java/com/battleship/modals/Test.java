package com.battleship.modals;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test {

	static int i = 0;
	
	public static void main(String[] args) {
		System.out.println(factorial(5));
		
		Map<Integer, String> map = new LinkedHashMap<>();
		System.out.println(map.keySet().stream().reduce((f, s) -> s).get());
		
	}
	

	public static int factorial (int fact) {
		int i = 1, factoria = 1;
		
		while(i <= fact) {
			factoria = factoria * i;
			i++;
		}
		return factoria;
	}
	
}