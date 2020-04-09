package com.monomer.data;

import java.util.ArrayList;

// class which stores and retrieves the date/times
public class DateTimeArray {
	
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
