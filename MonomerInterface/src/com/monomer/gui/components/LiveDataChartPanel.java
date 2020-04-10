package com.monomer.gui.components;

import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class LiveDataChartPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPanel chartPanel;
	
	public JPanel createLiveDataChartPanel() {
		
//		GridBagConstraints c = new GridBagConstraints();
//		c.fill = GridBagConstraints.HORIZONTAL;
		
		chartPanel = new JPanel();
		chartPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		chartPanel.setBackground(Color.white);
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.ipady = 520;      // make this component tall
//		c.weightx = 0.0;
//		c.gridwidth = 3;
//		c.gridx = 0;
//		c.gridy = 1;
//		c.anchor = GridBagConstraints.PAGE_END;
		
		return chartPanel;
	}

}
