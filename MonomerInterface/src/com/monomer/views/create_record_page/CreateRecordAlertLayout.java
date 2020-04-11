package com.monomer.views.create_record_page;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CreateRecordAlertLayout {
	
	GridBagConstraints alertLayout;
	
	public GridBagConstraints setAlertLayout() {
		
		alertLayout.fill = GridBagConstraints.HORIZONTAL;
		alertLayout.ipady = 10;
		alertLayout.gridx = 1;
		alertLayout.gridy = 1;
		alertLayout.insets = new Insets(0,20,0,20);	
		
		return alertLayout;
	}

	// batch id validation label
	c2.gridy = 1;
	
	// machine num validation label
	c2.gridy = 3;
	
	// bubble validation label
	c2.gridy = 5;
}
