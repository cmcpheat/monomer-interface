package com.monomer.views.create_record_page;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CreateRecordInputLayout {
	
	GridBagConstraints inputLayout;
	
	public GridBagConstraints setInputLayout() {
		
		inputLayout.fill = GridBagConstraints.HORIZONTAL;
		inputLayout.ipady = 20;
		inputLayout.weightx = 0.5;
		inputLayout.gridx = 1;
		inputLayout.insets = new Insets(20,20,5,20);	
		
		return inputLayout;
	}
}
