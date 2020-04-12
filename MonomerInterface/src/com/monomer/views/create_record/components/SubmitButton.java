package com.monomer.views.create_record.components;

import javax.swing.JButton;

public class SubmitButton {
	
	JButton submitButton;
	
	public JButton setSubmitButton() {
		
		submitButton = new JButton("Submit");
		//submitButton.addActionListener(this);
		
		return submitButton;
	}
}
