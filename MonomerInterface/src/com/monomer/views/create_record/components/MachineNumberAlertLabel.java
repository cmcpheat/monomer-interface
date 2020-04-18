package com.monomer.views.create_record.components;

import java.awt.Color;

import javax.swing.JLabel;

public class MachineNumberAlertLabel {
	
	JLabel machineNumberAlertLabel;
	
	public JLabel setMachineNumberAlertLabel() {
		
		machineNumberAlertLabel = new JLabel(" ", JLabel.CENTER);
		Color DARK_RED = new Color(204, 0, 0);
		machineNumberAlertLabel.setForeground(DARK_RED);
		machineNumberAlertLabel.setFont (machineNumberAlertLabel.getFont ().deriveFont (11.0f));

		return machineNumberAlertLabel;
	}
}
