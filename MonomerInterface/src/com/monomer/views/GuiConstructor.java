package com.monomer.views;

import com.monomer.controllers.CreateRecordController;
import com.monomer.views.live_data.LiveDataPage;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
//import javax.swing.ImageIcon;

public class GuiConstructor {
	
	private JFrame frame;

	// GUI constructor 
	public GuiConstructor() {
		
		// frame setup
		frame = new JFrame();
		frame.setResizable(false); // prevents resizing
		Dimension frameSize = new Dimension(1000, 700);
		frame.setPreferredSize(frameSize);
//		ImageIcon icon = new ImageIcon("/icon2.png");
//		frame.setIconImage(icon.getImage());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // allows processes to end before quitting 
		frame.setTitle("Monomer Data");
		
		// create tabs
		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(0,0,0,0);
		
		// create pages
		JPanel liveDataPage = new LiveDataPage().addLiveDataPage();
		JPanel createRecordPage = new CreateRecordController().addCreateRecordPage();
		
		// add pages to tabs
		tabs.add("Live Data", liveDataPage);
		tabs.add("Create a Record", createRecordPage);
		frame.add(tabs);
		
		// show GUI
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); // centres the window		
	}

	
}	
	
