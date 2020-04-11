package com.monomer.views.create_record_page.components;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

public class SubmitButton {
	
	JButton submitButton;
	
	public JButton setSubmitButton() {
		
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		
		return submitButton;
	}

}
