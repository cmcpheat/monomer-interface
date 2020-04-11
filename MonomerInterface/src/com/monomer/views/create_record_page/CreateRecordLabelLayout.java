package com.monomer.views.create_record_page;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CreateRecordLabelLayout {
	
	GridBagConstraints labelLayout = new GridBagConstraints();
	
	public GridBagConstraints setLabelLayout() {
		
		labelLayout.fill = GridBagConstraints.HORIZONTAL;
		labelLayout.ipady = 40;      //make this component tall
		labelLayout.weightx = 0.5;
		labelLayout.gridx = 0;
		labelLayout.insets = new Insets(20,20,0,20);	
		
		return labelLayout;
	}	
}
