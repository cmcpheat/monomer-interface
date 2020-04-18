package com.monomer.views.create_record.components;

import java.awt.Color;

import javax.swing.JLabel;

public class BubbleCountAlertLabel {
	
	private JLabel bubbleCountAlertLabel = new JLabel();
	
	public JLabel setBubbleCountAlertLabel() {

		bubbleCountAlertLabel = new JLabel(" ", JLabel.CENTER);
		Color DARK_RED = new Color(204, 0, 0);
		bubbleCountAlertLabel.setForeground(DARK_RED);
		bubbleCountAlertLabel.setFont (bubbleCountAlertLabel.getFont ().deriveFont (11.0f));
		
		return bubbleCountAlertLabel;		
	}
	
	public void clearField() {
		this.bubbleCountAlertLabel.setText(" ");
	}
}
