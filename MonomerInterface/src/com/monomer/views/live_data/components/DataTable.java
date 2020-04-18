package com.monomer.views.live_data.components;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.monomer.controllers.BatchIdController;
import com.monomer.controllers.BubbleCountController;
import com.monomer.controllers.DateTimeController;
import com.monomer.controllers.MachineNumberController;

public class DataTable {
	
	private ArrayList<String> batchList = new ArrayList<String>();
	private ArrayList<String> machineList = new ArrayList<String>();
	private ArrayList<String> bubbleList = new ArrayList<String>();
	private ArrayList<String> dateList = new ArrayList<String>();
	private BatchIdController batchIdController = new BatchIdController();
	private MachineNumberController machineNumberController = new MachineNumberController();
	private BubbleCountController bubbleCountController = new BubbleCountController();
	private DateTimeController dateTimeController = new DateTimeController();
	
	private DefaultTableModel table;
	
	public DefaultTableModel setDataTable() {
		
		table = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false - user cannot edit cells
		       return false;
		    }
		};
		table.addColumn("Batch ID");
        table.addColumn("Machine No.");
        table.addColumn("Bubble Count");
        table.addColumn("Date");
        
        batchList = batchIdController.getBatchIdList();
		machineList = machineNumberController.getMachineNumberList();
		bubbleList = bubbleCountController.getBubbleCountList();
		dateList = dateTimeController.getDateTimeList();
				
		// table.setRowCount(0);
		
		for (int i = 0; i < batchList.size(); i++) {
			
			String BA = batchList.get(i);
			String MN = machineList.get(i);
			String BC = bubbleList.get(i);
			String DT = dateList.get(i);
			
			table.insertRow(0, new Object[] { BA, MN, BC, DT });
		}

        return table;
	}
}

