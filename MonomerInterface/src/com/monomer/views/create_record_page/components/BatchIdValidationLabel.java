package com.monomer.views.create_record_page.components;

import java.awt.Color;

import javax.swing.JLabel;

public class BatchIdValidationLabel {
	
	JLabel batchIdValidationLabel;
	
	public JLabel setBatchIdValidationLabel() {
		
		batchIdValidationLabel = new JLabel(" ", JLabel.CENTER);
		batchIdValidationLabel.setForeground(Color.red);
		batchIdValidationLabel.setFont (batchIdValidationLabel.getFont ().deriveFont (11.0f));
	
		return batchIdValidationLabel;
	}

}
