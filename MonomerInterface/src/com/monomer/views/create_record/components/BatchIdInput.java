package com.monomer.views.create_record.components;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class BatchIdInput {
	
	private JTextField batchIdInput = new JTextField();
	
	public JTextField setBatchIdInput() {
		
		batchIdInput = new JTextField("", 20);
		batchIdInput.setBorder(BorderFactory.createCompoundBorder(
		batchIdInput.getBorder(), 
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		batchIdInput.setFont (batchIdInput.getFont ().deriveFont (12.0f));
	
		return batchIdInput;
	}
}
