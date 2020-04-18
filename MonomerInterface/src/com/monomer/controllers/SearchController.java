package com.monomer.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SearchController {
	
	private ArrayList<Integer> INDEX_RESULT;
	private static ArrayList<String> VALUE_RESULT;
	
	// linear search for searching UNSORTED array list for chosen machine number
	// returns list of indexes that the machine number exists at
	// use these indexes to search for the values at these positions in other arrays
	
	public ArrayList<Integer> linearSearchForIndexes(ArrayList<String> array, int key) {
		
		INDEX_RESULT = new ArrayList<Integer>();
		
		for (int index = 0; index < array.size(); index++) {
			
			String s = array.get(index);
			int i = Integer.parseInt(s);
			if (i == key) {
				INDEX_RESULT.add(index);
			}
		}
		return INDEX_RESULT;
	}
	
	// linear search which takes in a list of index numbers and a list of elements
	// returns the list of values in the elements at array at those index positions
	
	public ArrayList<String> arrayLinearSearch(ArrayList<Integer> indexes, ArrayList<String> elements) {
		
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
	
	// takes an array of date/times, the chosen range (e.g. 1 hour, 24 hours ...) and 
	// calculates if each element in array is within range...
	// returns the list of index numbers
	
	public ArrayList<Integer> dateRangeSearch(ArrayList<String> array, String range) {
		
		// get current time
		final LocalDateTime now = LocalDateTime.now();
		
		// get the earliest date in the range selected by user			
		LocalDateTime then = null;
		
		if (range == "last hour") {
			then = LocalDateTime.now().minusHours(1);
		}
		
		else if (range == "last 24 hours") {
			then = LocalDateTime.now().minusHours(24);
		}
		
		else if (range == "last 7 days") {
			then = LocalDateTime.now().minusDays(7);
		}
		
		else if (range == "last 30 days") {
			then = LocalDateTime.now().minusDays(30);
		}
		
		ArrayList<Integer> listOfIndexesInRange = new ArrayList<Integer>();
		
		int index = 0;
		int max = array.size();
		
		for (index = 0; index < max; index++) {
			
			String cellString = array.get(index);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime cellDate = LocalDateTime.parse(cellString, formatter);
			
			if (cellDate.isBefore(now) && cellDate.isAfter(then)) {
				 listOfIndexesInRange.add(index);
			}
		}
			
		return listOfIndexesInRange;
	}
	
	// takes in array of existing batch IDs and the batch ID the user has entered
	// checks if batch ID already exists in array
	// returns true if it exists, false if it does not 
	
	public boolean batchIdBinarySearch(ArrayList<String> array, int id) {
		
		int firstIndex = 0;
	    int lastIndex = array.size() - 1;

	    // termination condition (element isn't present)
	    while(firstIndex <= lastIndex) {
	    	
	    	int middleIndex = (firstIndex + lastIndex) / 2;
	    	
	    	int index = Integer.parseInt(array.get(middleIndex));
	        
	        // if the middle element is our goal element, return its index
	        if (index == id) {
	            return true;
	        }

	        // if the middle element is smaller
	        // point our index to the middle+1, taking the first half out of consideration
	        else if (index < id)
	            firstIndex = middleIndex + 1;

	        // if the middle element is bigger
	        // point our index to the middle-1, taking the second half out of consideration
	        else if (index > id)
	            lastIndex = middleIndex - 1;
	    }
		return false;
	}
}