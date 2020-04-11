package com.monomer.views.live_data_page.components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MachineOneButton implements ActionListener {
	
	private JButton machineOneBtn;
	private boolean machineOneActive = false;
	
	public JButton createLiveDataMachineOneButton() {
		
		machineOneBtn = new JButton("Machine 1");
		machineOneBtn.addActionListener(this);

		return machineOneBtn;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// handle 'machine 1' button click
		if (e.getSource() == machineOneBtn)
		{
			if (machineOneActive == false) {
				machineOneBtn.setBackground(Color.gray);
				machineOneActive = true;
			}	
			else if (machineOneActive == true) {
				machineOneBtn.setBackground(new JButton().getBackground());
				machineOneActive = false;
			}
		}
	}	
}
