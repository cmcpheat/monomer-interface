package com.monomer.views.create_record_page.components;

import java.awt.Color;

import javax.swing.JLabel;

public class BubbleCountAlertLabel {
	
	JLabel bubbleCountAlertLabel;
	
	public JLabel setBubbleCountAlertLabel() {

		bubbleCountAlertLabel = new JLabel(" ", JLabel.CENTER);
		bubbleCountAlertLabel.setForeground(Color.red);
		bubbleCountAlertLabel.setFont (bubbleCountAlertLabel.getFont ().deriveFont (11.0f));
		
		return bubbleCountAlertLabel;		
	}
}
