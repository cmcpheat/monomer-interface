package com.monomer.controllers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import com.monomer.models.BatchIdModel;
import com.monomer.models.DateTimeModel;
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
	private BatchIdModel batchIdList;
	private DateTimeModel dateTimeList = new DateTimeModel();
	private ArrayList<Integer> INDEX_LIST;
	
	// add all components to view
	
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
		dateFilter.addActionListener(this);
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
	
	// controller functions
	
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
		
		// handle date filter selection
		if (e.getSource() == dateFilter)
		{
			if (dateFilter.getSelectedItem() == "Last Hour") {
				System.out.println("last hour test");
				
				// now need to get all data that has date/time within last hour
				LocalDateTime now = getDateTimeNow().plusHours(1);
				LocalDateTime then = getEarliestDate(1);
				System.out.println("time now: " + now);
				System.out.println("1 hr ago: " + then);
				
				
				// get data in this time frame
				ArrayList<LocalDateTime> DT_LIST = dateTimeList.getWholeList();
				INDEX_LIST = DateTimeModel.searchForDateRange(DT_LIST, now, then);
				
				System.out.println("list of indexes: " + INDEX_LIST);
				
				
				//searchForDateRange(dae, now, then)
				
				
						
			}	
			else if (dateFilter.getSelectedItem() == "Last 24 Hours") {
				System.out.println("last 24 hours test");
				
				// now need to get all data that has date/time within last 24 hours
				LocalDateTime now = getDateTimeNow().plusHours(1);
				LocalDateTime then = getEarliestDate(24);
				System.out.println("time now: " + now);
				System.out.println("24hr ago: " + then);
				
				// get data in this time frame
				
				
							
			}
			else if (dateFilter.getSelectedItem() == "Last 7 Days") {
				System.out.println("last 7 days test");
				
				// now need to get all data that has date/time within last 7 days
				LocalDateTime now = getDateTimeNow().plusHours(1);
				LocalDateTime then = getEarliestDate(7);
				System.out.println("time now: " + now);
				System.out.println("7 dy ago: " + then);
				
				// get data in this time frame
				
				
			}
			else if (dateFilter.getSelectedItem() == "Last 30 Days") {
				System.out.println("last 30 days test");
								
				LocalDateTime now = getDateTimeNow().plusHours(1);
				LocalDateTime then = getEarliestDate(30);
				System.out.println("time now: " + now);
				System.out.println("30 d ago: " + then);
				
				// get data in this time frame
			}
		}
	}
	
	// add data to table
	public void addDataToTable(String datas) {
		
	}
	
	public LocalDateTime getDateTimeNow() {
		final LocalDateTime now = LocalDateTime.now();
		return now;
	}
	
	// get the earliest date in the range selected by user
	static LocalDateTime getEarliestDate(int range) {
			
		LocalDateTime result = null;

		switch (range) {
			// get last hour
			case 1:
				result = LocalDateTime.now().minusHours(1);
				return result;
			// get last 24 hours
			case 24:
				result = LocalDateTime.now().minusHours(24);
				return result;
			// get last 7 days
			case 7:
				result = LocalDateTime.now().minusDays(7);
				return result;
			// get last 30 days
			case 30:
				result = LocalDateTime.now().minusDays(30);
				return result;
			}
		return result;
	}	
		
}
