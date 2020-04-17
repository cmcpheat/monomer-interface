package com.monomer.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	
	public static ArrayList<Integer> dateRangeSearch(ArrayList<String> array, String range) {
		
		// get current time
		final LocalDateTime now = LocalDateTime.now();
		
		// get the earliest date in the range selected by user			
		LocalDateTime then = null;

			switch (range) {
				// get last hour
				case "last hour":
					System.out.println("case");
					then = LocalDateTime.now().minusHours(1);
				// get last 24 hours
				case "last 24 hours":
					then = LocalDateTime.now().minusHours(24);
				// get last 7 days
				case "last 7 days":
					then = LocalDateTime.now().minusDays(7);
				// get last 30 days
				case "last 30 days":
					then = LocalDateTime.now().minusDays(30);
				}
			
		DateTimeController dt = new DateTimeController();
		ArrayList<String> listOfDates = dt.getDateTimeList();
		ArrayList<Integer> listOfIndexesInRange = new ArrayList<Integer>();
		
		int index = 0;
		int max = listOfDates.size();
		
		for (index = 0; index < max; index++) {
			
			String cellString = listOfDates.get(index);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime cellDate = LocalDateTime.parse(cellString, formatter);

			// System.out.println("cell " + i +"," + 3 + ": " + cellDate );
			
			if (cellDate.isBefore(now) && cellDate.isAfter(then)) {
				 listOfIndexesInRange.add(index);
				 System.out.println(cellDate);
			}
//			else if (cellDate.isBefore(then)) {
//				System.out.println("DATE: " + cellDate + " is out of range");
//			}
		}
		return listOfIndexesInRange;
	}
		
	
	
}
