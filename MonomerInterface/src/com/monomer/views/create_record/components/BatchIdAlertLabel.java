package com.monomer.views.create_record.components;

import java.awt.Color;

import javax.swing.JLabel;

public class BatchIdAlertLabel {
	
	JLabel batchIdAlertLabel;
	
	public JLabel setBatchIdAlertLabel() {
		
		batchIdAlertLabel = new JLabel(" ", JLabel.CENTER);
		Color DARK_RED = new Color(204, 0, 0);
		batchIdAlertLabel.setForeground(DARK_RED);
		batchIdAlertLabel.setFont (batchIdAlertLabel.getFont ().deriveFont (11.0f));
	
		return batchIdAlertLabel;
	}
}
