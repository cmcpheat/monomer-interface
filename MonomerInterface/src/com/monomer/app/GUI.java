package com.monomer.app;

import com.monomer.gui.pages.create_record.CreateRecordPage;
import com.monomer.gui.pages.live_data.LiveDataPage;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class GUI {
	
	private JFrame frame;

	// GUI constructor 
	public GUI() {
		
		// create frame/window
		frame = new JFrame();
		frame.setResizable(false); // prevents resizing
		Dimension frameSize = new Dimension(1000, 700);
		frame.setPreferredSize(frameSize);
		ImageIcon icon = new ImageIcon("/icon2.png");
		frame.setIconImage(icon.getImage());
		
		// create tabs
		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(0,0,0,0);
		
		// create pages
		JPanel liveDataPage = new LiveDataPage().createLiveDataPage();
		JPanel createRecordPage = new CreateRecordPage().createCreateRecordPage();
		
		// add pages to tabs
		tabs.add("Live Data", liveDataPage);
		tabs.add("Create a Record", createRecordPage);
		frame.add(tabs);
		
		// GUI initialisation
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // allows processes to end before quitting 
		frame.setTitle("Monomer Data");
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); // centres the window		
	}

	
}	
	

