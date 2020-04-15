package com.monomer.views.live_data.layouts;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class LDButtonLayout extends GridBagConstraints {

	private static final long serialVersionUID = 1L;
	GridBagConstraints c = new GridBagConstraints();
	
	public GridBagConstraints setLiveDataButtonLayout() {
	
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;      //make this component tall
		c.insets = new Insets(30,20,15,20);  // padding
		c.weightx = 0.5;
		c.gridy = 0;
		
		return c;
	}

}
