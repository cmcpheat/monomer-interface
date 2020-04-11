package com.monomer.views.create_record_page.components;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import com.monomer.models.DataRecordModel;
import com.monomer.views.create_record_page.layouts.AlertLayout;
import com.monomer.views.create_record_page.layouts.ButtonLayout;
import com.monomer.views.create_record_page.layouts.InputLayout;
import com.monomer.views.create_record_page.layouts.LabelLayout;

public class CreateRecordPage implements ActionListener {
	
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
	private JButton clearButton;
	private JButton submitButton;
	private JLabel dataSubmittedLabel;
	private boolean batchIsValidFormat = false;
	private boolean bubbleIsValidFormat = false;
	private int batchId;
	private int machineNumber;
	private int bubbleCount;
	private String dateTime;
	
	public JPanel createCreateRecordPage() {
		
		// create a record page
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
		clearButton = new ClearButton().setClearButton();
		clearButton.addActionListener(this);
		buttonLayout.gridx = 0;
		formPanel.add(clearButton, buttonLayout);
		
		// add 'submit' button to form
		submitButton = new SubmitButton().setSubmitButton();
		submitButton.addActionListener(this);
		buttonLayout.gridx = 1;
		formPanel.add(submitButton, buttonLayout);
		
		// add 'data submitted' message label to form
		dataSubmittedLabel = new DataSubmittedLabel().setDataSubmittedLabel();
		labelLayout.gridy = 7;
		formPanel.add(dataSubmittedLabel, labelLayout);
		
		// data submitted label layout
//		c2.fill = GridBagConstraints.CENTER;
//		c2.ipady = 20;      // make this component tall
//		c2.gridwidth = 3;
//		c2.gridx = 0;
//		c2.gridy = 7;
//		c2.insets = new Insets(0,20,20,20);
		
		return createRecordPage;			
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// handle 'submit' button click
		if (e.getSource() == submitButton)
		{	
			boolean bId = validateBatchId(batchIdInput.getText());
			boolean mNum = validateMachineNum(machineNumberInput.getSelectedIndex());
			boolean bCount = validateBubbleCount(bubbleIsValidFormat);
			
			System.out.println("submit button before checks");
			
			// check if form fields are valid then do stuff...
			if (bId == true && mNum == true && bCount == true) {
				
				DataRecordModel data = new DataRecordModel();
				
				data.setBatchId(batchIdInput.getText());
				data.setMachineNumber((String) machineNumberInput.getSelectedItem());
				data.setBubbleCount(bubbleCountInput.getText());
				String currentDateTime = data.getCurrentDateTimeStamp();
				data.setDateTime(currentDateTime);
				
				System.out.println("batch test: " + data.getBatchId());
				System.out.println("machine test: " + data.getMachineNumber());
				System.out.println("bubble test: " + data.getBubbleCount());
				System.out.println("date test: " + data.getDateTime());
				
				// sendData(dataObj);				
				showSubmitMessage();
				clearForm();
	
				ArrayList<Integer> batches = new ArrayList<Integer>();
				ArrayList<Integer> machines = new ArrayList<Integer>();
				ArrayList<Integer> bubbles = new ArrayList<Integer>();
				ArrayList<String> dates = new ArrayList<String>();
				
				batches.add(batchId);
				machines.add(machineNumber);
				bubbles.add(bubbleCount);
				dates.add(dateTime);
				
//				System.out.println("batch: " + batches.get(0));
//				System.out.println("machine: " + machines.get(0));
//				System.out.println("bubble: " + bubbles.get(0));
//				System.out.println("date: " + dates.get(0));
			}
		}
		
		// handle 'clear' button click
		else if (e.getSource() == clearButton) {
			System.out.println("CLEAR PRESSED");
			clearForm();
			System.out.println("USER HAS CLEARED FORM");
		}
	}

	// checks if 'batch ID' is empty and in correct number range
	public boolean validateBatchId(String batch) {
		if (batch == "" || batchIdInput.getText().equals("")) {
			batchIdAlertLabel.setText("Enter a number between 1 - 999999");
			return false;
		}
		else {
			batchIdAlertLabel.setText(" ");
			return true;
		}
	}	
		
	// checks if 'machine number' is on default selection
	public boolean validateMachineNum(int machine) {
		if (machine == 0) {
			machineNumberAlertLabel.setText("Please select an option");
			return false;
		}
		else {
			machineNumberAlertLabel.setText(" ");
			return true;
		}
	}
	
	// checks if 'bubble count' is empty and in correct number range
	public boolean validateBubbleCount(boolean bubble) {
		if (bubble == false || bubbleCountInput.getText().equals("")) {
			bubbleCountAlertLabel.setText("Enter a number between 1 - 600");
			return false;
		}
		else {
			bubbleCountAlertLabel.setText(" ");
			return true;
		}
	}
	
	// shows data submitted message, disappears after 5 seconds
	public void showSubmitMessage () {
		dataSubmittedLabel.setText("The data has been submitted successfully.");
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
		catch (Exception e1) {
			dataSubmittedLabel.setText("There has been an error. Please try again");
		}
	}
	
	public void clearForm() {
		batchIdInput.setText("");
		batchIdAlertLabel.setText(" ");
		machineNumberInput.setSelectedIndex(0);
		machineNumberAlertLabel.setText(" ");
		bubbleCountInput.setText("");
		bubbleCountAlertLabel.setText(" ");
	}
}




