package com.monomer.views.live_data.components;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DataTable {
	
	private JTable table;
	
	public JTable setDataTable() {
		
	String data[][]={ {"1000","2","25", "2020-04-12 18:52:03"},
			{"1000","2","25", "2020-04-12 18:52:03"},
			{"1000","2","25", "2020-04-12 18:52:03"}};
		String column[]={"Batch ID","Machine No.","Bubble Count", "Date"};         
		
		table=new JTable(data,column);    
		// table.setBounds(3000,4000,200,300);     
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setPreferredSize(new Dimension(0, 0));
		table.getTableHeader().setDefaultRenderer(renderer);

		
		   
		
		return table;
	}

}

