package com.monomer.views.create_record.components;

import javax.swing.JButton;

public class CancelButton {
	
	JButton cancelButton = new JButton("Cancel");
	
	public JButton setClearButton() {
		
		this.cancelButton = new JButton("Cancel");
		return cancelButton;		
	}
}
