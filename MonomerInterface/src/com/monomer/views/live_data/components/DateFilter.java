package com.monomer.views.live_data.components;

import javax.swing.JComboBox;

public class DateFilter {
	
	private JComboBox<String> dateFilter;
	
	public JComboBox<String> setDateFilter() {
		
		dateFilter = new JComboBox<String>();
		dateFilter.addItem("Last Hour");
		dateFilter.addItem("Last 24 Hours");
		dateFilter.addItem("Last 7 Days");
		dateFilter.addItem("Last 30 Days");
		
		return dateFilter;
	}

}
