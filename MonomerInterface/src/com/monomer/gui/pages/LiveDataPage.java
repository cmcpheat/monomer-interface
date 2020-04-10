package com.monomer.gui.pages;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.monomer.data.DataObject;
import com.monomer.gui.components.LiveDataChartPanel;
import com.monomer.gui.components.LiveDataMachineOneButton;
import com.monomer.gui.components.LiveDataMachineThreeButton;
import com.monomer.gui.components.LiveDataMachineTwoButton;
import com.monomer.gui.styles.LiveDataButtons;
import com.monomer.gui.styles.LiveDataPanels;

public class LiveDataPage extends JPanel {
	
	// JPanel liveDataPage;
	// private JPanel chartPanel;
	JButton machineOneBtn;
	// private JButton machineTwoBtn;
	// private JButton machineThreeBtn;
	
//	public LiveDataPage() {
//		
//		System.out.println("inside live data page constructor");
//		
//		JPanel liveDataPage = new JPanel(new GridBagLayout());
//		
//		// Grid set up (for buttons and chart)
//		GridBagConstraints c = new GridBagConstraints();
//		c.fill = GridBagConstraints.HORIZONTAL;
//		
//		// Machine 1 button
//		// LiveDataMachineOneButton machineOneBtn = new LiveDataMachineOneButton();
//		
//		machineOneBtn = new JButton("Machine 1");
//		// machineOneBtn.addActionListener(this);
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.ipady = 20;      //make this component tall
//		c.insets = new Insets(0,20,15,20);  //top padding
//		c.weightx = 0.5;
//		c.gridx = 0;
//		c.gridy = 0;
//		
//		liveDataPage.add(machineOneBtn, c);
//		
//		// Machine 2 button
//		LiveDataMachineTwoButton machineTwoBtn = new LiveDataMachineTwoButton();
//		liveDataPage.add(machineTwoBtn, c);
//		 
//		// Machine 3 button
//		LiveDataMachineThreeButton machineThreeBtn = new LiveDataMachineThreeButton();
//		liveDataPage.add(machineThreeBtn, c);
//		 
//		// Panel for line chart
//		LiveDataChartPanel chartPanel = new LiveDataChartPanel();
//
//		// add chart panel to Live Data tab
//		liveDataPage.add(chartPanel, c);
//		
//	}
	
	public JPanel createLiveDataPage() {
		
		System.out.println("inside create live data page");
		
		JPanel liveDataPage = new JPanel(new GridBagLayout());
				
		GridBagConstraints btnStyles = new LiveDataButtons().setLiveDataButtonStyles();
		GridBagConstraints panelStyles = new LiveDataPanels().setLiveDataPanelStyles();
		
		// Machine 1 button
		JButton machineOneBtn = new LiveDataMachineOneButton().createLiveDataMachineOneButton();
		btnStyles.gridx = 0;
		liveDataPage.add(machineOneBtn, btnStyles);
		
		// Machine 2 button
		JButton machineTwoBtn = new LiveDataMachineTwoButton().createLiveDataMachineTwoButton();
		btnStyles.gridx = 1;
		liveDataPage.add(machineTwoBtn, btnStyles);
		 
		// Machine 3 button
		JButton machineThreeBtn = new LiveDataMachineThreeButton().createLiveDataMachineThreeButton();
		btnStyles.gridx = 2;
		liveDataPage.add(machineThreeBtn, btnStyles);
		 
		// Panel for line chart
		JPanel chartPanel = new LiveDataChartPanel().createLiveDataChartPanel();

		// add chart panel to Live Data tab
		liveDataPage.add(chartPanel, panelStyles);
		
		return liveDataPage;
		
	}
}
