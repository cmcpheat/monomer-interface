package com.monomer.gui.styles;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class LiveDataButtons extends GridBagConstraints {
	
	private static final long serialVersionUID = 1L;
	GridBagConstraints c = new GridBagConstraints();
	
	public GridBagConstraints setLiveDataButtonStyles() {
	
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;      //make this component tall
		c.insets = new Insets(0,20,15,20);  //top padding
		c.weightx = 0.5;
		c.gridy = 0;
		
		return c;
	}

}
