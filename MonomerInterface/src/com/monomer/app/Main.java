package com.monomer.app;

import com.monomer.views.GUI;
import com.monomer.views.Theme;

public class Main {
	
	// run the application
	public static void main(String[] args) {
		
		System.out.println("Starting app...");
		
		// set theme to 'nimbus' and run GUI
		Theme theme = new Theme();
		theme.setTheme();
		
		new GUI();

	}
}	