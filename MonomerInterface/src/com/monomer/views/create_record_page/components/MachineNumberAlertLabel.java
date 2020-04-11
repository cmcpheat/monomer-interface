package com.monomer.views.create_record_page.components;

import java.awt.Color;

import javax.swing.JLabel;

public class MachineNumberAlertLabel extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel machineNumberAlertLabel;
	
	public JLabel setMachineNumberAlertLabel() {
		
		machineNumberAlertLabel = new JLabel(" ", JLabel.CENTER);
		machineNumberAlertLabel.setForeground(Color.red);
		machineNumberAlertLabel.setFont (machineNumberAlertLabel.getFont ().deriveFont (11.0f));

		return machineNumberAlertLabel;
	}
}
