package com.monomer.gui.pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import com.monomer.data.DataObject;

public class CreateRecordPage implements ActionListener {
	
	private JPanel createRecordTab;
	private JPanel formPanel;
	private JButton submitBtn;
	private JButton clearBtn;
	private JLabel batchLabel;
	private JLabel batchValidationLabel;
	private JLabel machineLabel;
	private JLabel machineValidationLabel;
	private JLabel bubbleLabel;
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
	
	public CreateRecordPage() {
		
		createRecordTab = new JPanel(); 
		
		// Create a Record page
		// Grid set up for create record form
		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill = GridBagConstraints.HORIZONTAL;
		
		// form panel
		formPanel = new JPanel(new GridBagLayout());
		formPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		formPanel.setBorder(BorderFactory.createEmptyBorder(80, 10, 10, 10));
		
		// batch ID label
		batchLabel = new JLabel("Batch ID");
		c2.fill = GridBagConstraints.HORIZONTAL;
		batchLabel.setFont (batchLabel.getFont ().deriveFont (batchLabel.getFont().getStyle() | Font.BOLD));
		c2.ipady = 40;      //make this component tall
		c2.weightx = 0.5;
		c2.gridx = 0;
		c2.gridy = 0;
		c2.insets = new Insets(20,20,0,20);		
		formPanel.add(batchLabel, c2);
		
		// batch ID validation label // hidden by default
		batchValidationLabel = new JLabel(" ", JLabel.CENTER);
		batchValidationLabel.setForeground(Color.red);
		batchValidationLabel.setFont (batchValidationLabel.getFont ().deriveFont (11.0f));
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 10;
		c2.gridx = 1;
		c2.gridy = 1;
		c2.insets = new Insets(0,20,0,20);	
		formPanel.add(batchValidationLabel, c2);
		
		// machine no. label
		machineLabel = new JLabel("Machine Number");
		machineLabel.setFont (machineLabel.getFont ().deriveFont (machineLabel.getFont().getStyle() | Font.BOLD));
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 40;
		c2.weightx = 0.5;
		c2.gridx = 0;
		c2.gridy = 2;
		c2.insets = new Insets(20,20,15,20);
		formPanel.add(machineLabel, c2);
		
		// machine no. validation label // hidden by default
		machineValidationLabel = new JLabel(" ", JLabel.CENTER);
		machineValidationLabel.setForeground(Color.red);
		machineValidationLabel.setFont (batchValidationLabel.getFont ().deriveFont (11.0f));
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 1;
		c2.gridx = 1;
		c2.gridy = 3;
		c2.insets = new Insets(0,20,0,20);	
		formPanel.add(machineValidationLabel, c2);
		 
		// bubble count label
		bubbleLabel = new JLabel("Bubble Count");
		bubbleLabel.setFont (bubbleLabel.getFont ().deriveFont (bubbleLabel.getFont().getStyle() | Font.BOLD));
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 40;
		c2.weightx = 0.5;
		c2.gridx = 0;
		c2.gridy = 4;
		c2.insets = new Insets(20,20,0,20);
		formPanel.add(bubbleLabel, c2);
		
		// bubble count validation label // hidden by default
		bubbleValidationLabel = new JLabel(" ", JLabel.CENTER);
		bubbleValidationLabel.setForeground(Color.red);
		bubbleValidationLabel.setFont (bubbleValidationLabel.getFont ().deriveFont (11.0f));
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 1;
		c2.gridx = 1;
		c2.gridy = 5;
		c2.insets = new Insets(0,20,0,20);	
		formPanel.add(bubbleValidationLabel, c2);
	
		// batch ID text input
		batchText = new JTextField("", 20);
		// validates number between 000001 - 999999 and sets boolean to true/false
		batchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String str = batchText.getText();
				 try 
				 { 
		            Integer.parseInt(str);
		            int ii = Integer.parseInt(str);
		            if (ii < 1 || ii > 999999) {
		            	batchIsValidFormat = false;
					}
		            else {
		            	batchIsValidFormat = true;
		            	batchValidationLabel.setText(" ");
		            }
		        }  
		        catch (NumberFormatException e1)  
		        { 
		        	batchIsValidFormat = false;
		        } 
			}
		});
		batchText.setBorder(BorderFactory.createCompoundBorder(
		batchText.getBorder(), 
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		batchText.setFont (batchText.getFont ().deriveFont (12.0f));
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 20;
		c2.weightx = 0.5;
		c2.gridx = 1;
		c2.gridy = 0;
		c2.insets = new Insets(20,20,5,20);		
		formPanel.add(batchText, c2);
		
		// machine no. drop down
		machineText = new JComboBox<String>();     
		machineText.setBorder(BorderFactory.createCompoundBorder(
		machineText.getBorder(), 
        BorderFactory.createEmptyBorder(10, 10, 10, 0)));
		machineText.setFont (machineText.getFont ().deriveFont (12.0f));
		machineText.setBackground(Color.white);
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 30;
		c2.weightx = 0.5;
		c2.gridx = 1;
		c2.gridy = 2;
		c2.insets = new Insets(10,20,5,20);
		formPanel.add(machineText, c2);
	    machineText.addItem("Please select...");
	    machineText.addItem("1");c2.insets = new Insets(10,20,10,20);	
		machineText.addItem("2");
		machineText.addItem("3");
		 
		// bubble count text input
		bubbleText = new JTextField("");
		// validates number between 0-600 and sets boolean to true/false
		bubbleText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String str = bubbleText.getText();
				 try 
				 { 
		            Integer.parseInt(str);
		            int i = Integer.parseInt(str);
		            if (i < 0 || i > 600) {
		            	bubbleIsValidFormat = false;
					}
		            else {
		            	bubbleIsValidFormat = true;
		            	bubbleValidationLabel.setText(" ");
		            }
		        }  
		        catch (NumberFormatException e1)  
		        { 
		        	bubbleIsValidFormat = false;
		        } 
			}
		});
		bubbleText.setBorder(BorderFactory.createCompoundBorder(
		bubbleText.getBorder(), 
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		bubbleText.setFont (bubbleText.getFont ().deriveFont (12.0f));
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 20;
		c2.weightx = 1.5;
		c2.gridx = 1;
		c2.gridy = 4;
		c2.insets = new Insets(20,20,5,20);	
		formPanel.add(bubbleText, c2);
 
		// clear button
		clearBtn = new JButton("Clear");
		clearBtn.addActionListener(this);
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 20;      // make this component tall
		c2.weightx = 0.5;
		c2.gridwidth = 1;
		c2.gridx = 0;
		c2.gridy = 6;
		c2.insets = new Insets(20,20,20,20);
		formPanel.add(clearBtn, c2);
		
		// submit button
		submitBtn = new JButton("Submit");
		submitBtn.addActionListener(this);
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 20;      // make this component tall
		c2.weightx = 0.5;
		c2.gridwidth = 1;
		c2.gridx = 1;
		c2.gridy = 6;
		c2.insets = new Insets(20,20,20,20);
		formPanel.add(submitBtn, c2);
		
		// submitted message label (bottom of form)
		submitMessageLabel = new JLabel(" ");
		submitMessageLabel.setForeground(Color.red);
		submitMessageLabel.setFont (bubbleValidationLabel.getFont ().deriveFont (12.0f));
		c2.fill = GridBagConstraints.CENTER;
		c2.ipady = 20;      // make this component tall
		c2.gridwidth = 3;
		c2.gridx = 0;
		c2.gridy = 7;
		c2.insets = new Insets(0,20,20,20);
		formPanel.add(submitMessageLabel, c2);
		
		// add form to Create a Record tab
		createRecordTab.add(formPanel);	
		
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
				
				DataObject data = new DataObject();
				
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




