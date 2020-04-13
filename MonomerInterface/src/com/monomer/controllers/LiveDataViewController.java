package com.monomer.controllers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import com.monomer.views.live_data.components.ChartPanel;
import com.monomer.views.live_data.components.DataTable;
import com.monomer.views.live_data.components.DateFilter;
import com.monomer.views.live_data.components.MachineOneButton;
import com.monomer.views.live_data.components.MachineThreeButton;
import com.monomer.views.live_data.components.MachineTwoButton;
import com.monomer.views.live_data.layouts.ButtonLayout;
import com.monomer.views.live_data.layouts.PanelLayout;

public class LiveDataViewController implements ActionListener {
	
	private JPanel liveDataPage;
	private GridBagConstraints buttonLayout;
	private GridBagConstraints panelLayout;
	private JComboBox<String> dateFilter;
	private JButton machineOneButton;
	private JButton machineTwoButton;
	private JButton machineThreeButton;
	private JPanel chartPanel;
	private JTable table;
	private JTableHeader header;
	private boolean machineOneActive = false;
	private boolean machineTwoActive = false;
	private boolean machineThreeActive = false;
	
	public JPanel addLiveDataPage() {
		
		liveDataPage = new JPanel(new GridBagLayout());
				
		// set styling for layout
		buttonLayout = new ButtonLayout().setLiveDataButtonLayout();
		panelLayout = new PanelLayout().setLiveDataPanelLayout();
		
		// add 'machine 1' button
		machineOneButton = new MachineOneButton().setLiveDataMachineOneButton();
		machineOneButton.addActionListener(this);
		buttonLayout.gridx = 1;
		liveDataPage.add(machineOneButton, buttonLayout);
		
		// add 'machine 2' button
		machineTwoButton = new MachineTwoButton().setLiveDataMachineTwoButton();
		machineTwoButton.addActionListener(this);
		buttonLayout.gridx = 2;
		liveDataPage.add(machineTwoButton, buttonLayout);
		 
		// add 'machine 3' button
		machineThreeButton = new MachineThreeButton().setLiveDataMachineThreeButton();
		machineThreeButton.addActionListener(this);
		buttonLayout.gridx = 3;
		liveDataPage.add(machineThreeButton, buttonLayout);
		
		// add date filter drop-down
		dateFilter = new DateFilter().setDateFilter();
		buttonLayout.gridx = 0;
		liveDataPage.add(dateFilter, buttonLayout);
 
		// add panel for line chart
		chartPanel = new ChartPanel().setLiveDataChartPanel();
		liveDataPage.add(chartPanel, panelLayout);
		
		// add table for testing
		table = new DataTable().setDataTable();
		
		header = table.getTableHeader();
		// chartPanel.setLayout(new BorderLayout());
		chartPanel.add(header, BorderLayout.NORTH);
		chartPanel.add(table, BorderLayout.CENTER);
		
		JScrollPane sp=new JScrollPane(table); 
		
		chartPanel.add(sp, panelLayout);
		
		return liveDataPage;
	}
	
	// handle button clicks
	public void actionPerformed(ActionEvent e) {
		
		// handle 'machine 1' button click
		if (e.getSource() == machineOneButton)
		{
			if (machineOneActive == false) {
				machineOneButton.setBackground(Color.gray);
				machineOneActive = true;
			}	
			else if (machineOneActive == true) {
				machineOneButton.setBackground(new JButton().getBackground());
				machineOneActive = false;
			}
		}
		
		// handle 'machine 2' button click
		if (e.getSource() == machineTwoButton)
		{
			if (machineTwoActive == false) {
				machineTwoButton.setBackground(Color.gray);
				machineTwoActive = true;
			}	
			else if (machineTwoActive == true) {
				machineTwoButton.setBackground(new JButton().getBackground());
				machineTwoActive = false;
			}
		}
		
		// handle 'machine 3' button click
		if (e.getSource() == machineThreeButton)
		{
			if (machineThreeActive == false) {
				machineThreeButton.setBackground(Color.gray);
				machineThreeActive = true;
			}	
			else if (machineThreeActive == true) {
				machineThreeButton.setBackground(new JButton().getBackground());
				machineThreeActive = false;
			}
		}	
				
	}	
}
