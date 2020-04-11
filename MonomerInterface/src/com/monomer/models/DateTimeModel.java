package com.monomer.models;

import java.util.ArrayList;
import java.util.List;

public class DateTimeModel {
	
	public final List<String> dates = new ArrayList<>();
	
	public void addDateTime( String date ) {
		dates.add( date );
	}

}
