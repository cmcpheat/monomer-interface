package com.monomer.views.create_record.components;

import java.awt.Font;

import javax.swing.JLabel;

public class BubbleCountLabel {
	
	JLabel bubbleCountLabel;
	
	public JLabel setBubbleCountLabel() {
		
		bubbleCountLabel = new JLabel("Bubble Count");
		bubbleCountLabel.setFont (bubbleCountLabel.getFont ().deriveFont (bubbleCountLabel.getFont().getStyle() | Font.BOLD));
		
		return bubbleCountLabel;
	}
}

