package com.monomer.views;

// import com.monomer.app.Singleton;
import com.monomer.controllers.CreateRecordViewController;
import com.monomer.controllers.LiveDataViewController;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
//import javax.swing.ImageIcon;

public class GUI {
	
	private JFrame frame;

	// GUI constructor 
	public GUI() {
		
		// Singleton tmp = Singleton.getInstance();
		
		// frame setup
		frame = new JFrame();
		frame.setResizable(false); // prevents resizing
		Dimension frameSize = new Dimension(1000, 700);
		frame.setPreferredSize(frameSize);
//		ImageIcon icon = new ImageIcon("/icon2.png");
//		frame.setIconImage(icon.getImage());
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // allows processes to end before quitting 
		frame.addWindowListener(exitListener);
		frame.setTitle("Monomer Data");
		
		// create tabs
		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(0,0,0,0);
		
		// create pages
		JPanel liveDataPage = new LiveDataViewController().addLiveDataPage();
		JPanel createRecordPage = new CreateRecordViewController().addCreateRecordPage();
		
		// add pages to tabs
		tabs.add("Live Data", liveDataPage);
		tabs.add("Create a Record", createRecordPage);
		frame.add(tabs);
		
		// show GUI
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); // centres the window	
	}
			
	WindowListener exitListener = new WindowAdapter() {
		
		@Override
		public void windowClosing(WindowEvent e) {
			int confirm = JOptionPane.showOptionDialog(
	             null, "Are you sure you want to close?", 
	             "Confirm Close", JOptionPane.YES_NO_OPTION, 
	             JOptionPane.QUESTION_MESSAGE, null, null, null);
	        if (confirm == 0) {
//	        	batchIdModel = new BatchIdModel();
//	        	try {
//					batchIdModel.save();
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
	        	System.exit(0);
	        }
		}
	};
}	
	

