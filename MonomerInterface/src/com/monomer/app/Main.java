package com.monomer.app;

import java.io.IOException;

import com.monomer.models.BatchIdModel;
import com.monomer.models.BubbleCountModel;
import com.monomer.models.DateTimeModel;
import com.monomer.models.MachineNumberModel;
import com.monomer.views.GUI;
import com.monomer.views.Theme;

public class Main {
	
	// run the application
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		System.out.println("Starting app... \n");
		
		// set theme to 'nimbus' and run GUI
		Theme theme = new Theme();
		theme.setTheme();
		
		// load previous Batch IDs from file
		BatchIdModel ba = new BatchIdModel();
		ba.read();
		
		// load previous Bubble Counts from file
		BubbleCountModel bu = new BubbleCountModel();
		bu.read();
		
		// load previous Machine Numbers from file
		MachineNumberModel ma = new MachineNumberModel();
		ma.read();
		
		// load previous Date & Times from file
		DateTimeModel dt = new DateTimeModel();
		dt.read();
		
		new GUI();	
	}
}	