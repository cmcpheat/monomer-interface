package com.monomer.views.live_data;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.monomer.views.live_data.components.ChartPanel;
import com.monomer.views.live_data.components.MachineOneButton;
import com.monomer.views.live_data.components.MachineThreeButton;
import com.monomer.views.live_data.components.MachineTwoButton;
import com.monomer.views.live_data.layouts.ButtonLayout;
import com.monomer.views.live_data.layouts.PanelLayout;

public class LiveDataPage {

	public JPanel addLiveDataPage() {
		
		JPanel liveDataPage = new JPanel(new GridBagLayout());
				
		// set styling for layout
		GridBagConstraints btnStyles = new ButtonLayout().setLiveDataButtonLayout();
		GridBagConstraints panelStyles = new PanelLayout().setLiveDataPanelLayout();
		
		// add 'machine 1' button
		JButton machineOneBtn = new MachineOneButton().createLiveDataMachineOneButton();
		btnStyles.gridx = 0;
		liveDataPage.add(machineOneBtn, btnStyles);
		
		// add 'machine 2' button
		JButton machineTwoBtn = new MachineTwoButton().createLiveDataMachineTwoButton();
		btnStyles.gridx = 1;
		liveDataPage.add(machineTwoBtn, btnStyles);
		 
		// add 'machine 3' button
		JButton machineThreeBtn = new MachineThreeButton().createLiveDataMachineThreeButton();
		btnStyles.gridx = 2;
		liveDataPage.add(machineThreeBtn, btnStyles);
		 
		// add panel for line chart
		JPanel chartPanel = new ChartPanel().createLiveDataChartPanel();
		liveDataPage.add(chartPanel, panelStyles);
		
		return liveDataPage;
	}
}
