package com.monomer.views.create_record.components;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class BubbleCountInput {
	
	JTextField bubbleCountInput;
	boolean bubbleIsValidFormat;
	
	public JTextField setBubbleCountInput() {
		
		bubbleCountInput = new JTextField("");
		bubbleCountInput.setBorder(BorderFactory.createCompoundBorder(
		bubbleCountInput.getBorder(), 
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		bubbleCountInput.setFont (bubbleCountInput.getFont ().deriveFont (12.0f));
		
		return bubbleCountInput;
	}
}
