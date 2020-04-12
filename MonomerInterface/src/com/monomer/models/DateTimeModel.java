package com.monomer.models;

import java.util.ArrayList;

public class DateTimeModel {
	
	ArrayList<String> DATE_TIME_LIST = new ArrayList<String>();
	
	public DateTimeModel () {
		
	}
	
	public void setDateTime(String dt)
	{		
		DATE_TIME_LIST.add(dt);
	}
	
	public String getDateTime(int index) {
		return DATE_TIME_LIST.get(index);
	}
	
	public void printAllDateTimes() {
		System.out.println("DT List: " + DATE_TIME_LIST);
	}

}