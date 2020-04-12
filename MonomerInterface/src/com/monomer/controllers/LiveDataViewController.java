package com.monomer.controllers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;

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

public class LiveDataViewController {
	
	private JPanel liveDataPage;
	private GridBagConstraints buttonLayout;
	private GridBagConstraints panelLayout;
	private JComboBox<String> dateFilter;
	private JButton machineOneButton;
	private JButton machineTwoButton;
	private JButton machineThreeButton;
	private JPanel chartPanel;
	private JTable table;
	
	public JPanel addLiveDataPage() {
		
		liveDataPage = new JPanel(new GridBagLayout());
				
		// set styling for layout
		buttonLayout = new ButtonLayout().setLiveDataButtonLayout();
		panelLayout = new PanelLayout().setLiveDataPanelLayout();
		
		// add 'machine 1' button
		machineOneButton = new MachineOneButton().setLiveDataMachineOneButton();
		buttonLayout.gridx = 1;
		liveDataPage.add(machineOneButton, buttonLayout);
		
		// add 'machine 2' button
		machineTwoButton = new MachineTwoButton().setLiveDataMachineTwoButton();
		buttonLayout.gridx = 2;
		liveDataPage.add(machineTwoButton, buttonLayout);
		 
		// add 'machine 3' button
		machineThreeButton = new MachineThreeButton().setLiveDataMachineThreeButton();
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
		String data[][]={ {"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"},
				{"1000","2","25", "2020-04-12 18:52:03"}};
			String column[]={"Batch ID","Machine No.","Bubble Count", "Date"};         
			
		table=new JTable(data,column);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);  
		JTableHeader header = table.getTableHeader();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(header, BorderLayout.NORTH);
		panel.add(table, BorderLayout.CENTER);
		
		JScrollPane sp=new JScrollPane(table); 
		
		chartPanel.add(sp);
		
		return liveDataPage;
	}
}
