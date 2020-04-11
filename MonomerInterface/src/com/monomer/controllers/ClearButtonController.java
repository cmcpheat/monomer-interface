package com.monomer.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.monomer.views.create_record_page.components.BatchIdAlertLabel;
import com.monomer.views.create_record_page.components.BatchIdInput;
import com.monomer.views.create_record_page.components.BubbleCountAlertLabel;
import com.monomer.views.create_record_page.components.BubbleCountInput;
import com.monomer.views.create_record_page.components.ClearButton;
import com.monomer.views.create_record_page.components.MachineNumberAlertLabel;
import com.monomer.views.create_record_page.components.MachineNumberInput;

public class ClearButtonController {
	
	private ClearButton clearButton;
	private BatchIdInput batchIdInput;
	private BatchIdAlertLabel batchIdAlertLabel;
	private MachineNumberInput machineNumberInput;
	private MachineNumberAlertLabel machineNumberAlertLabel;
	private BubbleCountInput bubbleCountInput;
	private BubbleCountAlertLabel bubbleCountAlertLabel;
	
	public ClearButtonController(ClearButton clearButton, BatchIdInput batchIdInput, 
			BatchIdAlertLabel batchIdAlertLabel, MachineNumberInput machineNumberInput, 
			MachineNumberAlertLabel machineNumberAlertLabel, BubbleCountInput bubbleCountInput, 
			BubbleCountAlertLabel bubbleCountAlertLabel) {
		
		System.out.println("Clear button controller constructor");
		
		this.clearButton = clearButton;
		this.batchIdInput = batchIdInput;
		this.batchIdAlertLabel = batchIdAlertLabel;
		this.machineNumberInput = machineNumberInput;
		this.machineNumberAlertLabel = machineNumberAlertLabel;
		this.bubbleCountInput = bubbleCountInput;
		this.bubbleCountAlertLabel = bubbleCountAlertLabel;
		
		// this.clearButton.clearButtonListener(new ClearButtonListener());
	}
	
	class ClearButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			System.out.println("clear button pressed");
			
			batchIdInput.setText("");
			batchIdAlertLabel.setText(" ");
			machineNumberInput.setSelectedIndex(0);
			machineNumberAlertLabel.setText(" ");
			bubbleCountInput.setText("");
			bubbleCountAlertLabel.setText(" ");
			
		}
	}	

}
