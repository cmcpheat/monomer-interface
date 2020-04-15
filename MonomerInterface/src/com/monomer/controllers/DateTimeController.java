package com.monomer.controllers;

import java.util.ArrayList;

public class DateTimeController {
	
	private ArrayList<String> list = new ArrayList<>();
		
	public ArrayList<String> getDateTimeList() {
		return list;
	}
	
	public String getDateAtIndex(int index) {
		String date = list.get(index);
		return date;
	}

}
