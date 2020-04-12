package com.monomer.views.live_data.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MachineThreeButton implements ActionListener {
	
	private JButton machineThreeBtn;
	private boolean machineThreeActive = false;

	public JButton setLiveDataMachineThreeButton() {
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		machineThreeBtn = new JButton("Machine 3");
		machineThreeBtn.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		
		return machineThreeBtn;		
	}
	
	public void actionPerformed(ActionEvent e) {

		// handle 'machine 3' button click
		if (e.getSource() == machineThreeBtn)
		{
			if (machineThreeActive == false) {
				machineThreeBtn.setBackground(Color.gray);
				machineThreeActive = true;
			}	
			else if (machineThreeActive == true) {
				machineThreeBtn.setBackground(new JButton().getBackground());
				machineThreeActive = false;
			}
		}
	}
}
