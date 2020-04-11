package com.monomer.views.create_record_page.components;

import java.awt.Color;

import javax.swing.JLabel;

public class BatchIdAlertLabel {
	
	JLabel batchIdAlertLabel;
	
	public JLabel setBatchIdAlertLabel() {
		
		batchIdAlertLabel = new JLabel(" ", JLabel.CENTER);
		batchIdAlertLabel.setForeground(Color.red);
		batchIdAlertLabel.setFont (batchIdAlertLabel.getFont ().deriveFont (11.0f));
	
		return batchIdAlertLabel;
	}
}
