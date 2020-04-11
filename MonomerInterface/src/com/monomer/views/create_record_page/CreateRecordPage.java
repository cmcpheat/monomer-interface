package com.monomer.views.create_record_page;

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
import com.monomer.views.create_record_page.components.BatchIdAlertLabel;
import com.monomer.views.create_record_page.components.BatchIdInput;
import com.monomer.views.create_record_page.components.BatchIdLabel;
import com.monomer.views.create_record_page.components.BubbleCountAlertLabel;
import com.monomer.views.create_record_page.components.BubbleCountInput;
import com.monomer.views.create_record_page.components.BubbleCountLabel;
import com.monomer.views.create_record_page.components.ClearButton;
import com.monomer.views.create_record_page.components.CreateRecordFormPanel;
import com.monomer.views.create_record_page.components.DataSubmittedLabel;
import com.monomer.views.create_record_page.components.MachineNumberAlertLabel;
import com.monomer.views.create_record_page.components.MachineNumberInput;
import com.monomer.views.create_record_page.components.MachineNumberLabel;
import com.monomer.views.create_record_page.components.SubmitButton;

public class CreateRecordPage implements ActionListener {
	
	private JButton submitBtn;
	private JButton clearBtn;
	private JLabel batchValidationLabel;
	private JLabel machineValidationLabel;
	private JLabel bubbleValidationLabel;
	private JLabel submitMessageLabel;
	private JTextField batchText;
	private JComboBox<String> machineText;
	private JTextField bubbleText;
	private boolean batchIsValidFormat = false;
	private boolean bubbleIsValidFormat = false;
	private int batchId;
	private int machineNumber;
	private int bubbleCount;
	private String dateTime;
	
	public JPanel createCreateRecordPage() {
		
		// create a record page
		JPanel createRecordPage = new JPanel(); 
		
		// set layout for components
		GridBagConstraints labelLayout = new CreateRecordLabelLayout().setLabelLayout(); // done
		GridBagConstraints buttonLayout = new CreateRecordButtonLayout().setButtonLayout(); // done
		GridBagConstraints inputLayout = new CreateRecordInputLayout().setInputLayout(); // done
		GridBagConstraints alertLayout = new CreateRecordAlertLayout().setAlertLayout(); // done
		
		// add form panel to page
		JPanel formPanel = new CreateRecordFormPanel().setCreateRecordFormPanel();
		createRecordPage.add(formPanel);
		
		// add 'batch ID' label to form
		JLabel batchIdLabel = new BatchIdLabel().setBatchIdLabel();
		labelLayout.gridy = 0;
		formPanel.add(batchIdLabel, labelLayout);
			
		// add batch ID alert label to form
		JLabel batchIdAlertLabel = new BatchIdAlertLabel().setBatchIdAlertLabel();
		alertLayout.gridy = 1;
		formPanel.add(batchIdAlertLabel, alertLayout);
		
		// add 'machine number' label to form
		JLabel machineNumberLabel = new MachineNumberLabel().setMachineNumberLabel();
		labelLayout.gridy = 2;
		formPanel.add(machineNumberLabel, labelLayout);
		
		// add machine number alert label to form
		JLabel machineNumberAlertLabel = new MachineNumberAlertLabel().setMachineNumberAlertLabel();
		alertLayout.gridy = 3;
		formPanel.add(machineNumberAlertLabel, alertLayout);
		
		// add 'bubble count' label to form
		JLabel bubbleCountLabel = new BubbleCountLabel().setBubbleCountLabel();
		labelLayout.gridy = 4;		
		formPanel.add(bubbleCountLabel, labelLayout);
		
		// add bubble count alert label to form
		JLabel bubbleCountAlertLabel = new BubbleCountAlertLabel().setBubbleCountAlertLabel();
		alertLayout.gridy = 5;
		formPanel.add(bubbleCountAlertLabel, alertLayout);
		
		// add 'batch ID' text input to form
		JTextField batchIdInput = new BatchIdInput().setBatchIdInput();
		inputLayout.gridy = 0;
		formPanel.add(batchIdInput, inputLayout);
		
		// add 'machine number' drop-down to form
		JComboBox<String> machineNumberInput = new MachineNumberInput().setMachineNumberInput();
		inputLayout.gridy = 2;
		inputLayout.ipady = 30;
		formPanel.add(machineNumberInput, inputLayout);
		
		// add 'bubble count' text input to form
		JTextField bubbleCountTextInput = new BubbleCountInput().setBubbleCountInput();
		inputLayout.ipady = 20;
		inputLayout.gridy = 4;
		formPanel.add(bubbleCountTextInput, inputLayout);
		
		// add 'clear' button to form
		JButton clearButton = new ClearButton().setClearButton();
		buttonLayout.gridx = 0;
		formPanel.add(clearButton, buttonLayout);
		
		// add 'submit' button to form
		JButton submitButton = new SubmitButton().setSubmitButton();
		buttonLayout.gridx = 1;
		formPanel.add(submitButton, buttonLayout);
		
		// add 'data submitted' message label to form
		JLabel dataSubmittedLabel = new DataSubmittedLabel().setDataSubmittedLabel();
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
		if (e.getSource() == submitBtn)
		{	
			boolean bId = validateBatchId(batchIsValidFormat);
			boolean mNum = validateMachineNum(machineText.getSelectedIndex());
			boolean bCount = validateBubbleCount(bubbleIsValidFormat);
			
			// check if form fields are valid then do stuff...
			if (bId == true && mNum == true && bCount == true) {
				
				DataRecordModel data = new DataRecordModel();
				
				data.setBatchId(batchText.getText());
				data.setMachineNumber((String) machineText.getSelectedItem());
				data.setBubbleCount(bubbleText.getText());
				String currentDateTime = data.getCurrentDateTimeStamp();
				data.setDateTime(currentDateTime);
				
				System.out.println("batch test: " + data.getBatchId());
				System.out.println("machine test: " + data.getMachineNumber());
				System.out.println("bubble test: " + data.getBubbleCount());
				System.out.println("date test: " + data.getDateTime());
				
				// sendData(dataObj);				
				showSubmitMessage();
				clearForm();
				System.out.println("here");
	
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
		else if (e.getSource() == clearBtn) {
			clearForm();
			System.out.println("USER HAS CLEARED FORM");
		}
	}

	// checks if 'batch ID' is empty and in correct number range
	public boolean validateBatchId(boolean batch) {
		if (batch == false || batchText.getText().equals("")) {
			batchValidationLabel.setText("Enter a number between 1 - 999999");
			return false;
		}
		else {
			batchValidationLabel.setText(" ");
			return true;
		}
	}	
		
	// checks if 'machine number' is on default selection
	public boolean validateMachineNum(int machine) {
		if (machine == 0) {
			machineValidationLabel.setText("Please select an option");
			return false;
		}
		else {
			machineValidationLabel.setText(" ");
			return true;
		}
	}
	
	// checks if 'bubble count' is empty and in correct number range
	public boolean validateBubbleCount(boolean bubble) {
		if (bubble == false || bubbleText.getText().equals("")) {
			bubbleValidationLabel.setText("Enter a number between 1 - 600");
			return false;
		}
		else {
			bubbleValidationLabel.setText(" ");
			return true;
		}
	}
	
	// shows data submitted message, disappears after 5 seconds
	public void showSubmitMessage () {
		submitMessageLabel.setText("The data has been submitted successfully.");
		try {
			int delay = 5000;
			Timer timer = new Timer(delay, new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					submitMessageLabel.setText(" "); 
				}	
			});
			timer.setRepeats(false);
			timer.start();
		}
		catch (Exception e1) {
			submitMessageLabel.setText("There has been an error.");
		}
	}
	
	public void clearForm() {
		batchText.setText("");
		batchValidationLabel.setText(" ");
		machineText.setSelectedIndex(0);
		machineValidationLabel.setText(" ");
		bubbleText.setText("");
		bubbleValidationLabel.setText(" ");
	}
}




