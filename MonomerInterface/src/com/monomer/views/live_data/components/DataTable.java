package com.monomer.views.live_data.components;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataTable {
	
	private DefaultTableModel model;
	
	public DefaultTableModel setDataTable() {
		
		model = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		model.addColumn("Batch ID");
        model.addColumn("Machine No.");
        model.addColumn("Bubble Count");
        model.addColumn("Date");
        
        
       
		
        return model;
	}
}

