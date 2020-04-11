package com.monomer.views.live_data_page;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class LiveDataChartPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPanel chartPanel;
	
	public JPanel createLiveDataChartPanel() {
		
		chartPanel = new JPanel();
		chartPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		chartPanel.setBackground(Color.white);
		
		return chartPanel;
	}

}
