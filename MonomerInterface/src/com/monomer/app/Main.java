package com.monomer.app;

import com.monomer.models.BatchIdModel;
import com.monomer.models.BubbleCountModel;
import com.monomer.models.DateTimeModel;
import com.monomer.models.MachineNumberModel;
import com.monomer.views.GuiConstructor;
import com.monomer.views.Theme;

public class Main {
	
	// run the application
	public static void main(String[] args) {
		
		System.out.println("Starting app...");
		
		// set theme to 'nimbus' and run GUI
		Theme theme = new Theme();
		theme.setTheme();
		new GuiConstructor();
		
//		new BatchIdModel();
//		new BubbleCountModel();
//		new MachineNumberModel();
//		new DateTimeModel();
	}
}	