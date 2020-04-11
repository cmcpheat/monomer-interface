package com.monomer.views.live_data_page;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class LiveDataPanelLayout extends GridBagConstraints {

	private static final long serialVersionUID = 1L;
	GridBagConstraints c = new GridBagConstraints();
	
	public GridBagConstraints setLiveDataPanelLayout() {
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 520;      // make this component tall
		c.insets = new Insets(0,20,15,20);  // padding
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_END;
		
		return c;		
	}

}
