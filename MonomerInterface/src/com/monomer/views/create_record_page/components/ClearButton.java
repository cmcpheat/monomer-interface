package com.monomer.views.create_record_page.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import com.monomer.models.DataRecordModel;

public class ClearButton {
	
	JButton clearButton = new JButton("Clear");
	
	public JButton setClearButton() {
		
		this.clearButton = new JButton("Clear");
		// clearButton.addActionListener(this);
		
		return clearButton;		
	}
	
//	public void clearForm() {
//		System.out.println("clearForm() function running");
//		batchIdInput.setText("");
//		batchIdAlertLabel.setText(" ");
//		machineNumberInput.setSelectedIndex(0);
//		machineNumberAlertLabel.setText(" ");
//		bubbleCountInput.setText("");
//		bubbleCountAlertLabel.setText(" ");
//}
//	
//	public void clearButtonListener(ActionListener listenerForClearButton) {
//		
//		System.out.println("called the clear button listener function");
//		
//		this.clearButton.addActionListener(listenerForClearButton);
//		
//	}
}
