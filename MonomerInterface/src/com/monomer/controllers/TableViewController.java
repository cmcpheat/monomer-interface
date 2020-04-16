package com.monomer.controllers;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class TableViewController {
	
	private ArrayList<String> batchList = new ArrayList<String>();
	private ArrayList<String> machineList = new ArrayList<String>();
	private ArrayList<String> bubbleList = new ArrayList<String>();
	private ArrayList<String> dateList = new ArrayList<String>();
	private BatchIdController batchIdController = new BatchIdController();
	private MachineNumberController machineNumberController = new MachineNumberController();
	private BubbleCountController bubbleCountController = new BubbleCountController();
	private DateTimeController dateTimeController = new DateTimeController();
	
	public DefaultTableModel updateTable(DefaultTableModel table) {
		batchList = batchIdController.getBatchIdList();
		machineList = machineNumberController.getMachineNumberList();
		bubbleList = bubbleCountController.getBubbleCountList();
		dateList = dateTimeController.getDateTimeList();
				
		table.setRowCount(0);
		
		for (int i = 0; i < batchList.size(); i++) {
			
			String BA = batchList.get(i);
			String MN = machineList.get(i);
			String BC = bubbleList.get(i);
			String DT = dateList.get(i);
			
			table.insertRow(0, new Object[] { BA, MN, BC, DT });
		}
		System.out.println("here");
		
		return table;
	}
}
