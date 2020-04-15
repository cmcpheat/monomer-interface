package com.monomer.controllers;

import java.util.ArrayList;

public class LinearSearchController {
	
	private ArrayList<Integer> INDEX_RESULT;
	private static ArrayList<String> VALUE_RESULT;
	
	// linear search for searching UNSORTED array list for chosen machine number
	// returns list of indexes that the machine number exists at
	// use these indexes to search for the values at these positions in other arrays
	
	public ArrayList<Integer> linearSearchForIndexes(ArrayList<String> array, String key) {
		
		INDEX_RESULT = new ArrayList<Integer>();
		
		for (int index = 0; index < array.size(); index++) {
			
			String s = array.get(index);
			
			if (s == key) {
				INDEX_RESULT.add(index);
			}
		}
		return INDEX_RESULT;
	}
	
	// linear search which takes in a list of index numbers and a list of elements
	// returns the list of values in the elements at array at those index positions
	
	public static ArrayList<String> arrayLinearSearch(ArrayList<Integer> indexes, ArrayList<String> elements) {
		
		VALUE_RESULT = new ArrayList<String>();
		
		for (int i = 0; i < indexes.size(); i++) {
			
			for (int y = 0; y < elements.size(); y++) {
				
				if (indexes.get(i) == y) {
					VALUE_RESULT.add(elements.get(y));
				}
			}
		}
		return VALUE_RESULT;
	}
	
}
