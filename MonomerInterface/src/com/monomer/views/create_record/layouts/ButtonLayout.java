package com.monomer.views.create_record.layouts;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ButtonLayout {
	
	GridBagConstraints buttonLayout = new GridBagConstraints();
	
	public GridBagConstraints setButtonLayout() {
		
		buttonLayout.fill = GridBagConstraints.HORIZONTAL;
		buttonLayout.ipady = 20;
		buttonLayout.weightx = 0.5;
		buttonLayout.gridwidth = 1;
		buttonLayout.gridy = 6;
		buttonLayout.insets = new Insets(20,20,20,20);
		
		return buttonLayout;
	}
}
