package com.monomer.app;

import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.SwingUtilities;

import com.monomer.controllers.BatchIdController;
import com.monomer.controllers.GuiController;
import com.monomer.views.Theme;

public class Main {
	
	public static ServerSocket ss;
	static BatchIdController batchIdController = new BatchIdController();
	
	// run the application
	public static void main(String[] args) {
		
		ss = null;
		System.out.println("Starting app... \n");
		try {
			ss = new ServerSocket(1044);			
		}
		catch (IOException io) {
			System.err.println("Application already running!");
			System.exit(-1);
		}
		
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