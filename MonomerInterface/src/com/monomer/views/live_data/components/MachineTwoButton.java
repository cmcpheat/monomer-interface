package com.monomer.views.live_data.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MachineTwoButton implements ActionListener {
	
	private JButton machineTwoBtn;
	private boolean machineTwoActive = false;
	
	public JButton createLiveDataMachineTwoButton() {
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		machineTwoBtn = new JButton("Machine 2");
		machineTwoBtn.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		
		return machineTwoBtn;
	}

	public void actionPerformed(ActionEvent e) {

		// handle 'machine 2' button click
		if (e.getSource() == machineTwoBtn)
		{
			if (machineTwoActive == false) {
				machineTwoBtn.setBackground(Color.gray);
				machineTwoActive = true;
			}	
			else if (machineTwoActive == true) {
				machineTwoBtn.setBackground(new JButton().getBackground());
				machineTwoActive = false;
			}
		}
	}
}
