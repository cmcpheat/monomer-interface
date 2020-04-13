package com.monomer.controllers;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import com.monomer.models.BatchIdModel;
import com.monomer.models.BubbleCountModel;
import com.monomer.models.DateTimeModel;
import com.monomer.models.MachineNumberModel;
import com.monomer.views.create_record.components.BatchIdAlertLabel;
import com.monomer.views.create_record.components.BatchIdInput;
import com.monomer.views.create_record.components.BatchIdLabel;
import com.monomer.views.create_record.components.BubbleCountAlertLabel;
import com.monomer.views.create_record.components.BubbleCountInput;
import com.monomer.views.create_record.components.BubbleCountLabel;
import com.monomer.views.create_record.components.CancelButton;
import com.monomer.views.create_record.components.DataSubmittedLabel;
import com.monomer.views.create_record.components.FormPanel;
import com.monomer.views.create_record.components.MachineNumberAlertLabel;
import com.monomer.views.create_record.components.MachineNumberInput;
import com.monomer.views.create_record.components.MachineNumberLabel;
import com.monomer.views.create_record.components.SubmitButton;
import com.monomer.views.create_record.layouts.AlertLayout;
import com.monomer.views.create_record.layouts.ButtonLayout;
import com.monomer.views.create_record.layouts.InputLayout;
import com.monomer.views.create_record.layouts.LabelLayout;

public class CreateRecordViewController implements ActionListener {
	
	private JPanel createRecordPage;
	private JPanel formPanel;
	private JLabel batchIdLabel;
	private JTextField batchIdInput;
	private JLabel batchIdAlertLabel;
	private JLabel machineNumberLabel;
	private JComboBox<String> machineNumberInput;
	private JLabel machineNumberAlertLabel;
	private JLabel bubbleCountLabel;
	private JTextField bubbleCountInput;
	private JLabel bubbleCountAlertLabel;
	private JButton cancelButton;
	private JButton submitButton;
	private JLabel dataSubmittedLabel;
	BatchIdModel batchIdList = new BatchIdModel();
	BubbleCountModel bubbleCountList = new BubbleCountModel();
	MachineNumberModel machineNumberList = new MachineNumberModel();
	DateTimeModel dateTimeList = new DateTimeModel();
	
	public JPanel addCreateRecordPage() {
		
		// add the 'create a record' page
		createRecordPage = new JPanel(); 
		
		// set layout for components
		GridBagConstraints labelLayout = new LabelLayout().setLabelLayout(); // done
		GridBagConstraints buttonLayout = new ButtonLayout().setButtonLayout(); // done
		GridBagConstraints inputLayout = new InputLayout().setInputLayout(); // done
		GridBagConstraints alertLayout = new AlertLayout().setAlertLayout(); // done
		
		// add form panel to page
		formPanel = new FormPanel().setCreateRecordFormPanel();
		createRecordPage.add(formPanel);
		
		// add 'batch ID' label to form
		batchIdLabel = new BatchIdLabel().setBatchIdLabel();
		labelLayout.gridy = 0;
		formPanel.add(batchIdLabel, labelLayout);
			
		// add batch ID alert label to form
		batchIdAlertLabel = new BatchIdAlertLabel().setBatchIdAlertLabel();
		alertLayout.gridy = 1;
		formPanel.add(batchIdAlertLabel, alertLayout);
		
		// add 'machine number' label to form
		machineNumberLabel = new MachineNumberLabel().setMachineNumberLabel();
		labelLayout.gridy = 2;
		formPanel.add(machineNumberLabel, labelLayout);
		
		// add machine number alert label to form
		machineNumberAlertLabel = new MachineNumberAlertLabel().setMachineNumberAlertLabel();
		alertLayout.gridy = 3;
		formPanel.add(machineNumberAlertLabel, alertLayout);
		
		// add 'bubble count' label to form
		bubbleCountLabel = new BubbleCountLabel().setBubbleCountLabel();
		labelLayout.gridy = 4;		
		formPanel.add(bubbleCountLabel, labelLayout);
		
		// add bubble count alert label to form
		bubbleCountAlertLabel = new BubbleCountAlertLabel().setBubbleCountAlertLabel();
		alertLayout.gridy = 5;
		formPanel.add(bubbleCountAlertLabel, alertLayout);
		
		// add 'batch ID' text input to form
		batchIdInput = new BatchIdInput().setBatchIdInput();
		inputLayout.gridy = 0;
		formPanel.add(batchIdInput, inputLayout);
		
		// add 'machine number' drop-down to form
		machineNumberInput = new MachineNumberInput().setMachineNumberInput();
		inputLayout.gridy = 2;
		inputLayout.ipady = 30;
		formPanel.add(machineNumberInput, inputLayout);
		
		// add 'bubble count' text input to form
		bubbleCountInput = new BubbleCountInput().setBubbleCountInput();
		inputLayout.ipady = 20;
		inputLayout.gridy = 4;
		formPanel.add(bubbleCountInput, inputLayout);
		
		// add 'clear' button to form
		cancelButton = new CancelButton().setClearButton();
		cancelButton.addActionListener(this);
		buttonLayout.gridx = 0;
		formPanel.add(cancelButton, buttonLayout);
		
		// add 'submit' button to form
		submitButton = new SubmitButton().setSubmitButton();
		submitButton.addActionListener(this);
		buttonLayout.gridx = 1;
		formPanel.add(submitButton, buttonLayout);
		
		// add 'data submitted' message label to form
		dataSubmittedLabel = new DataSubmittedLabel().setDataSubmittedLabel();
		labelLayout.fill = GridBagConstraints.CENTER;
		labelLayout.gridwidth = 3;
		labelLayout.gridx = 0;
		labelLayout.gridy = 7;
		labelLayout.insets = new Insets(0,20,20,20);
		formPanel.add(dataSubmittedLabel, labelLayout);
		
		return createRecordPage;			
	}
	
	// controller functions
	
	public void actionPerformed(ActionEvent e) {
		
		// handle 'submit' button click
		if (e.getSource() == submitButton)
		{	
			final LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
			String batchId = batchIdInput.getText();
			String machineNumber = (String) machineNumberInput.getSelectedItem();
			String bubbleCount = bubbleCountInput.getText();
			String dateTime = currentDateTime.format(formatter);
			
			boolean batchValid = validateBatchId(batchId);
			boolean machineValid = validateMachineNum(machineNumberInput.getSelectedIndex());
			boolean bubbleValid = validateBubbleCount(bubbleCount);
			
			// check if form fields are valid then do stuff...
			if (batchValid == true && machineValid == true && bubbleValid == true) {
				
				int BATCH_ID = Integer.parseInt(batchId);
				int MACHINE_NUMBER = Integer.parseInt(machineNumber);
				int BUBBLE_COUNT = Integer.parseInt(bubbleCount);
			
				try
				{
					// add data to array lists
					batchIdList.setBatchId(BATCH_ID);
					machineNumberList.setMachineNumber(MACHINE_NUMBER);
					bubbleCountList.setBubbleCount(BUBBLE_COUNT);
					dateTimeList.setDateTime(dateTime);
					
					showSubmitMessage(BATCH_ID);
				}
				catch (Exception exc)
				{
					// error shown if exception caught 
					dataSubmittedLabel.setText("There has been an error. Please try again.");
				}
				
				clearForm();
				
				batchIdList.printAllBatchIds();
				machineNumberList.printAllMachineNumbers();
				bubbleCountList.printAllBubbleCounts();
				dateTimeList.printAllDateTimes();
			}
		}
		
		// handle 'clear' button click
		else if (e.getSource() == cancelButton) {
			clearForm();
		}
	}

	// checks if 'batch ID' is integer and in correct number range
	public boolean validateBatchId(String batch) {
		try 
		{ 
			Integer.parseInt(batch);
			int i = Integer.parseInt(batch);
			if (i < 1 || i > 999999) {
				batchIdAlertLabel.setText("Enter a number between 1-999999");
				return false;
			}
			else {
			batchIdAlertLabel.setText(" ");
			return true;
			}
		}  
		catch (NumberFormatException ex)  
		{ 
			batchIdAlertLabel.setText("Enter a number between 1-999999");
			return false;
		}
	}	
		
	// checks if 'machine number' is on default selection
	public boolean validateMachineNum(int index) {
		if (index == 0) {
			machineNumberAlertLabel.setText("Please select an option");
			return false;
		}
		else {
			machineNumberAlertLabel.setText(" ");
			return true;
		}
	}
	
	// checks if 'bubble count' is integer and in correct number range
	public boolean validateBubbleCount(String bubble) {
		
		try 
		{
			Integer.parseInt(bubble);
			int i = Integer.parseInt(bubble);
			if (i < 0 || i > 600) {
				bubbleCountAlertLabel.setText("Enter a number between 0-600");
				return false;
			}
			else {
				bubbleCountAlertLabel.setText(" ");
				return true;
			}
		}  
		catch (NumberFormatException exc)  
		{
			bubbleCountAlertLabel.setText("Enter a number between 0-600");
			return false;
       	} 
	}
	
	// shows data submitted message, disappears after 5 seconds
	public void showSubmitMessage (int b) {
		dataSubmittedLabel.setText("Batch #" + b + " data has been submitted successfully.");
		try {
			int delay = 5000;
			Timer timer = new Timer(delay, new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					dataSubmittedLabel.setText(" "); 
				}	
			});
			timer.setRepeats(false);
			timer.start();
		}
		catch (Exception exc2) {
			dataSubmittedLabel.setText("There has been an error. Please try again");
		}
	}
	
	// deletes all fields on form
	public void clearForm() {
		batchIdInput.setText("");
		batchIdAlertLabel.setText(" ");
		machineNumberInput.setSelectedIndex(0);
		machineNumberAlertLabel.setText(" ");
		bubbleCountInput.setText("");
		bubbleCountAlertLabel.setText(" ");
	}
}




