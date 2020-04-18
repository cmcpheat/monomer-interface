package com.monomer.app;

import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.SwingUtilities;

import com.monomer.controllers.GuiController;
import com.monomer.views.Theme;

public class Main {
	
	public static ServerSocket ss;
	
	// run the application
	public static void main(String[] args) {
		
		// set theme to custom
		Theme theme = new Theme();
		theme.setTheme();
		
		ss = null;
		System.out.println("Starting app... \n");
		
		// only one instance of app is allowed to run
		try {
			ss = new ServerSocket(1044);
			
			// GUI runs on its own thread
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new GuiController();	
				}
			});
		}
		catch (IOException io) {
			System.err.println("Application failed to start. Check if an instance is already running.");
			System.exit(-1);
		}
	}
}	