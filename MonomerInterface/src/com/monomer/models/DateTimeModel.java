package com.monomer.models;

import java.util.ArrayList;

public class DateTimeModel {
	
	private ArrayList<String> list = new ArrayList<>();
		
	public ArrayList<String> getDateTimeList() {
		return list;
	}
	
	public String getDateAtIndex(int index) {
		String date = list.get(index);
		return date;
	}

}
