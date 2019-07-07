package com.grocerryshop.mygrocerry.constants;

import java.util.HashMap;

public class GrocerryConstats {
	public static final HashMap<Character, Integer> discounts = new HashMap<>();
	static {
		discounts.put('E', 30);
		discounts.put('A', 10);

	}
}
