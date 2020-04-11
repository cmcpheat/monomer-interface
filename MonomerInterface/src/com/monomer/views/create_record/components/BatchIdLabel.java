package com.monomer.views.create_record.components;

import java.awt.Font;

import javax.swing.JLabel;

public class BatchIdLabel {
	
	JLabel batchIdLabel;
	
	public JLabel setBatchIdLabel() {
		
		batchIdLabel = new JLabel("Batch ID");
		batchIdLabel.setFont (batchIdLabel.getFont ().deriveFont (batchIdLabel.getFont().getStyle() | Font.BOLD));
		
		return batchIdLabel;
	}
}
