package com.monomer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class GUI implements ActionListener {
	
	private JFrame mainFrame;
	private JPanel liveDataTab;
	private JPanel createRecordTab;
	private JPanel chartPanel;
	private JButton machineOneBtn;
	private JButton machineTwoBtn;
	private JButton machineThreeBtn;
	
	public GUI() {
		
		// Frame set up
		mainFrame = new JFrame();
		mainFrame.setResizable(false); // prevents resizing
		Dimension frameSize = new Dimension(1000, 700);
		mainFrame.setPreferredSize(frameSize);
//		ImageIcon icon = new ImageIcon("");
//		mainFrame.setIconImage(icon.getImage());
		
		// Tabs set up
		liveDataTab = new JPanel(new GridBagLayout());
		createRecordTab = new JPanel(); 
		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(0,0,0,0);
		tabs.add("Live Data", liveDataTab);
		tabs.add("Create a Record", createRecordTab);
		mainFrame.add(tabs);
		
		// Grid set up (for buttons and chart)
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	
		// Machine 1 button
		machineOneBtn = new JButton("Machine 1");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;      //make this component tall
		c.insets = new Insets(0,20,15,20);  //top padding
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		liveDataTab.add(machineOneBtn, c);
		
		// Machine 2 button
		machineTwoBtn = new JButton("Machine 2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		liveDataTab.add(machineTwoBtn, c);
		 
		// Machine 3 button
		machineThreeBtn = new JButton("Machine 3");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		liveDataTab.add(machineThreeBtn, c);
		 
		// Panel for line chart
		chartPanel = new JPanel();
		chartPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 520;      // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_END;
		liveDataTab.add(chartPanel, c);		

		// Frame initialisation		
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // allows processes to end before quitting 
		mainFrame.setTitle("Monomer Data");
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null); // centres the window
		mainFrame.setVisible(true);
			
	}

	public static void main(String[] args) {
		new GUI();
	}

	public void actionPerformed(ActionEvent e) {

	}

}
