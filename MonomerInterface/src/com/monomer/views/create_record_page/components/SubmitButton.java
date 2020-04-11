package com.monomer.views.create_record_page.components;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SubmitButton {
	
	JButton submitButton;
	
	public JButton setSubmitButton() {
		
		submitButton = new JButton("Submit");
		//submitButton.addActionListener(this);
		
		return submitButton;
	}
	
	void submitButtonListener(ActionListener listenerForSubmitButton) {
		
		submitButton.addActionListener(listenerForSubmitButton);
		
	}

}
