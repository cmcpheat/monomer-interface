package com.monomer.views.create_record.components;

import java.awt.Font;

import javax.swing.JLabel;

public class MachineNumberLabel {
	
	JLabel machineNumberLabel;
	
	public JLabel setMachineNumberLabel() {
		
		machineNumberLabel = new JLabel("Machine Number");
		machineNumberLabel.setFont (machineNumberLabel.getFont ().deriveFont (machineNumberLabel.getFont().getStyle() | Font.BOLD));
	
		return machineNumberLabel;
	}
}
