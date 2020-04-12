package com.monomer.views.live_data.components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ChartPanel {
	
	private JPanel chartPanel;
	
	public JPanel createLiveDataChartPanel() {
		
		chartPanel = new JPanel();
		chartPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		chartPanel.setBackground(Color.white);
		
		return chartPanel;
	}

}
