package com.monomer.models;

import java.util.ArrayList;

// class which stores and retrieves the date/times
public class DateTimeModel {
	
	private static ArrayList<Integer> dateTimes = new ArrayList<Integer>();
	private static int dateTime;
	
	public static void setBatchId(int dt) {
		dateTimes.add(dt);
	}
	
	public static int getBatchId(int index) {
		dateTime = dateTimes.get(index);
		return dateTime;
	}

}
