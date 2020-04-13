package com.monomer.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DateTimeModel {
	
	ArrayList<LocalDateTime> DATE_TIME_LIST = new ArrayList<LocalDateTime>();
	ArrayList<Integer> SEARCH_RESULT = new ArrayList<Integer>();
	ArrayList<Integer> LIST_OF_INDEXES = new ArrayList<Integer>();
	
	
	public DateTimeModel () {
		
	}
	
	public void setDateTime(LocalDateTime dt)
	{		
		DATE_TIME_LIST.add(dt);
	}
	
	// takes in index number at returns date/time string at that position
	public LocalDateTime getDateTime(int index) {
		return DATE_TIME_LIST.get(index);
	}
	
	public ArrayList<Integer> searchForDateRange(LocalDateTime current, LocalDateTime range) {
		
		// takes in date selection
		// searches through the DATE_TIME_LIST for date selection
		// returns the list of array index numbers that are in that range
		
		
		
		
		return LIST_OF_INDEXES;
	}
	

	
	public void printAllDateTimes() {
		System.out.println("DT List: " + DATE_TIME_LIST);
	}
	
	
}