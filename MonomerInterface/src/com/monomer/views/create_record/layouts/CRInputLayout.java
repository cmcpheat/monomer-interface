package com.monomer.views.create_record.layouts;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CRInputLayout {
	
	GridBagConstraints inputLayout = new GridBagConstraints();
	
	public GridBagConstraints setInputLayout() {
		
		inputLayout.fill = GridBagConstraints.HORIZONTAL;
		inputLayout.ipady = 20;
		inputLayout.weightx = 0.5;
		inputLayout.gridx = 1;
		inputLayout.insets = new Insets(20,20,5,20);	
		
		return inputLayout;
	}
}
