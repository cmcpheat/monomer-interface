package com.monomer.views.create_record.components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;

public class MachineNumberInput {
	
	JComboBox<String> machineNumberInput;
	
	public JComboBox<String> setMachineNumberInput() {
		
		machineNumberInput = new JComboBox<String>();     
		machineNumberInput.setBorder(BorderFactory.createCompoundBorder(
		machineNumberInput.getBorder(), 
        BorderFactory.createEmptyBorder(10, 10, 10, 0)));
		machineNumberInput.setFont (machineNumberInput.getFont ().deriveFont (12.0f));
		machineNumberInput.setBackground(Color.white);
	    machineNumberInput.addItem("Please select...");
	    machineNumberInput.addItem("1");
		machineNumberInput.addItem("2");
		machineNumberInput.addItem("3");
		
		return machineNumberInput;
	}	
}
