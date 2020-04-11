package com.monomer.views.create_record_page.components;

import java.awt.Color;

import javax.swing.JLabel;

public class MachineNumberValidationLabel {
	
	JLabel machineNumberValidationLabel;
	
	public JLabel setMachineNumberValidationLabel() {
		
		machineNumberValidationLabel = new JLabel(" ", JLabel.CENTER);
		machineNumberValidationLabel.setForeground(Color.red);
		machineNumberValidationLabel.setFont (machineNumberValidationLabel.getFont ().deriveFont (11.0f));

		return machineNumberValidationLabel;
	}
}
