package com.monomer.views.create_record_page.components;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClearButton {
	
	JButton clearButton;
	
	public JButton setClearButton() {
		
		this.clearButton = new JButton("Clear");
		//clearButton.addActionListener(this);
		
		return clearButton;		
	}
	
	void clearButtonListener(ActionListener listenerForClearButton) {
		
		clearButton.addActionListener(listenerForClearButton);
		
	}
}
