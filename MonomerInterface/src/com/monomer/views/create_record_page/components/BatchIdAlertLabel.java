package com.monomer.views.create_record_page.components;

import java.awt.Color;

import javax.swing.JLabel;

public class BatchIdAlertLabel extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel batchIdAlertLabel;
	
	public JLabel setBatchIdAlertLabel() {
		
		batchIdAlertLabel = new JLabel(" ", JLabel.CENTER);
		batchIdAlertLabel.setForeground(Color.red);
		batchIdAlertLabel.setFont (batchIdAlertLabel.getFont ().deriveFont (11.0f));
	
		return batchIdAlertLabel;
	}
}
