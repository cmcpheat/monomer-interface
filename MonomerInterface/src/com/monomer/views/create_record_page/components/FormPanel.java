package com.monomer.views.create_record_page.components;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class FormPanel {
	
	JPanel formPanel;
	
	public JPanel setCreateRecordFormPanel() {

		formPanel = new JPanel(new GridBagLayout());
		formPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		formPanel.setBorder(BorderFactory.createEmptyBorder(80, 10, 10, 10));
		
		return formPanel;
	}
}
