package com.monomer.views.create_record_page.components;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

public class ClearButton {
	
	JButton clearButton;
	
	public JButton setClearButton() {
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		
		return clearButton;		
	}

}
