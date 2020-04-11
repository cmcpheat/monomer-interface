package com.monomer.views.create_record_page;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CreateRecordButtonLayout {
	
	GridBagConstraints buttonLayout;
	
	public GridBagConstraints setButtonLayout() {
		
		buttonLayout.fill = GridBagConstraints.HORIZONTAL;
		buttonLayout.ipady = 20;      // make this component tall
		buttonLayout.weightx = 0.5;
		buttonLayout.gridwidth = 1;
		buttonLayout.gridy = 6;
		buttonLayout.insets = new Insets(20,20,20,20);
		
		return buttonLayout;
	}
}
