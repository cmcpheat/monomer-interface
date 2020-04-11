package com.monomer.views.create_record_page.components;

import java.awt.Color;

import javax.swing.JLabel;

public class BubbleCountAlertLabel extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel bubbleCountAlertLabel = new JLabel();
	
	public JLabel setBubbleCountAlertLabel() {

		bubbleCountAlertLabel = new JLabel(" ", JLabel.CENTER);
		bubbleCountAlertLabel.setForeground(Color.red);
		bubbleCountAlertLabel.setFont (bubbleCountAlertLabel.getFont ().deriveFont (11.0f));
		
		return bubbleCountAlertLabel;		
	}
	
	public void clearField() {
		this.bubbleCountAlertLabel.setText(" ");
	}
}
