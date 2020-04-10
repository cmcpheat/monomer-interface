package com.monomer.app;

public class Main {
	
	// run the application
	
	public static void main(String[] args) {
		
		System.out.println("Starting app...");
		
		// set theme to 'nimbus'
		Theme theme = new Theme();
		theme.setTheme();
		
		// start GUI
		new GUI();
	}

}
