package com.monomer.views.create_record.components;

import java.awt.Color;

import javax.swing.JLabel;

public class DataSubmittedLabel {
	
	JLabel dataSubmittedLabel;
	
	public JLabel setDataSubmittedLabel() {
		
		dataSubmittedLabel = new JLabel(" ");
		Color DARK_RED = new Color(204, 0, 0);
		dataSubmittedLabel.setForeground(DARK_RED);
		dataSubmittedLabel.setFont (dataSubmittedLabel.getFont ().deriveFont (12.0f));
		
		return dataSubmittedLabel;
	}

}
