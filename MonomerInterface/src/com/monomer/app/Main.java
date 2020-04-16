package com.monomer.app;

import javax.swing.SwingUtilities;

import com.monomer.controllers.GuiController;
import com.monomer.views.Theme;

public class Main {
	
	// run the application
	public static void main(String[] args) {
		
		System.out.println("Starting app... \n");
		
		// set theme to 'nimbus'
		Theme theme = new Theme();
		theme.setTheme();

		// GUI runs on its own thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GuiController();	
			}
		});
	}
}	