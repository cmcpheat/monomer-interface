package com.monomer.views.create_record_page;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CreateRecordAlertLayout {
	
	GridBagConstraints alertLayout = new GridBagConstraints();
	
	public GridBagConstraints setAlertLayout() {
		
		alertLayout.fill = GridBagConstraints.HORIZONTAL;
		alertLayout.ipady = 10;
		alertLayout.gridx = 1;
		alertLayout.gridy = 1;
		alertLayout.insets = new Insets(0,20,0,20);	
		
		return alertLayout;
	}
}
