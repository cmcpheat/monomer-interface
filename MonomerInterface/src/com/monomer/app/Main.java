package com.monomer.app;

import java.io.IOException;

import com.monomer.views.GUI;
import com.monomer.views.Theme;

public class Main {
	
	// run the application
	public static void main(String[] args) throws IOException {
		
		System.out.println("Starting app... \n");
		
		// set theme to 'nimbus' and run GUI
		Theme theme = new Theme();
		theme.setTheme();
		
		// TODO read saved data from files
//		// load previous Batch IDs from file
//		BatchIdListController bilc = new BatchIdListController();
//		bilc.readListFromFile();
		
//		// load previous Bubble Counts from file
//		BubbleCountModel bu = new BubbleCountModel();
//		bu.read();
//		
//		// load previous Machine Numbers from file
//		MachineNumberModel ma = new MachineNumberModel();
//		ma.read();
//		
//		// load previous Date & Times from file
//		DateTimeModel dt = new DateTimeModel();
//		dt.read();
		
		new GUI();	
	}
}	