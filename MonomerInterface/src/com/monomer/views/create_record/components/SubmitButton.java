package com.monomer.views.create_record.components;

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
		
		System.out.println("submit button listener func");
		
		submitButton.addActionListener(listenerForSubmitButton);
		
	}
	
	// validation listener?

}
