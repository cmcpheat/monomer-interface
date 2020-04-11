package com.monomer.views.live_data_page;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LiveDataPage {

	public JPanel createLiveDataPage() {
		
		JPanel liveDataPage = new JPanel(new GridBagLayout());
				
		// set styling for layout
		GridBagConstraints btnStyles = new LiveDataButtonLayout().setLiveDataButtonLayout();
		GridBagConstraints panelStyles = new LiveDataPanelLayout().setLiveDataPanelLayout();
		
		// add 'machine 1' button
		JButton machineOneBtn = new LiveDataMachineOneButton().createLiveDataMachineOneButton();
		btnStyles.gridx = 0;
		liveDataPage.add(machineOneBtn, btnStyles);
		
		// add 'machine 2' button
		JButton machineTwoBtn = new LiveDataMachineTwoButton().createLiveDataMachineTwoButton();
		btnStyles.gridx = 1;
		liveDataPage.add(machineTwoBtn, btnStyles);
		 
		// add 'machine 3' button
		JButton machineThreeBtn = new LiveDataMachineThreeButton().createLiveDataMachineThreeButton();
		btnStyles.gridx = 2;
		liveDataPage.add(machineThreeBtn, btnStyles);
		 
		// add panel for line chart
		JPanel chartPanel = new LiveDataChartPanel().createLiveDataChartPanel();
		liveDataPage.add(chartPanel, panelStyles);
		
		return liveDataPage;
	}
}
