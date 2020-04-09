package com.monomer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class GUI implements ActionListener  {
	
	private JFrame mainFrame;
	private JPanel liveDataTab;
	private JPanel createRecordTab;
	private JPanel chartPanel;
	private JButton machineOneBtn;
	private JButton machineTwoBtn;
	private JButton machineThreeBtn;
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
	private String batchIdValueString;
	private String machineNumValueString;
	private String bubbleCountValueString;
	private boolean isActive1 = false;
	private boolean isActive2 = false;
	private boolean isActive3 = false;
	private boolean batchIsValid = false;
	private boolean bubbleIsValid = false;
	private int batchId;
	private int machineNumber;
	private int bubbleCount;
	private String dateTime;

	// GUI constructor 
	public GUI() {
		
		// Frame set up
		mainFrame = new JFrame();
		mainFrame.setResizable(false); // prevents resizing
		Dimension frameSize = new Dimension(1000, 700);
		mainFrame.setPreferredSize(frameSize);
		ImageIcon icon = new ImageIcon("/icon2.png");
		mainFrame.setIconImage(icon.getImage());
		
		// Tabs set up
		liveDataTab = new JPanel(new GridBagLayout());
		createRecordTab = new JPanel(); 
		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(0,0,0,0);
		tabs.add("Live Data", liveDataTab);
		tabs.add("Create a Record", createRecordTab);
		mainFrame.add(tabs);
		
		// Grid set up (for buttons and chart)
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Live Data page
		// Machine 1 button
		machineOneBtn = new JButton("Machine 1");
		machineOneBtn.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;      //make this component tall
		c.insets = new Insets(0,20,15,20);  //top padding
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		liveDataTab.add(machineOneBtn, c);
		
		// Machine 2 button
		machineTwoBtn = new JButton("Machine 2");
		machineTwoBtn.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		liveDataTab.add(machineTwoBtn, c);
		 
		// Machine 3 button
		machineThreeBtn = new JButton("Machine 3");
		machineThreeBtn.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		liveDataTab.add(machineThreeBtn, c);
		 
		// Panel for line chart
		chartPanel = new JPanel();
		chartPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		chartPanel.setBackground(Color.white);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 520;      // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_END;
		liveDataTab.add(chartPanel, c);
		
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
		            	batchIsValid = false;
					}
		            else {
		            	batchIsValid = true;
		            	batchValidationLabel.setText(" ");
		            }
		        }  
		        catch (NumberFormatException e1)  
		        { 
		        	batchIsValid = false;
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
		            if (i < 1 || i > 600) {
		            	bubbleIsValid = false;
					}
		            else {
		            	bubbleIsValid = true;
		            	bubbleValidationLabel.setText(" ");
		            }
		        }  
		        catch (NumberFormatException e1)  
		        { 
		        	bubbleIsValid = false;
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
		
		// GUI initialisation
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // allows processes to end before quitting 
		mainFrame.setTitle("Monomer Data");
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null); // centres the window		
	}

	public void actionPerformed(ActionEvent e) {
		
		// handle 'machine 1' button click
		if (e.getSource() == machineOneBtn)
		{
			if (isActive1 == false) {
				machineOneBtn.setBackground(Color.gray);
				isActive1 = true;
			}	
			else if (isActive1 == true) {
				machineOneBtn.setBackground(new JButton().getBackground());
				isActive1 = false;
			}
		}

		// handle 'machine 2' button click
		if (e.getSource() == machineTwoBtn)
		{
			if (isActive2 == false) {
				machineTwoBtn.setBackground(Color.gray);
				isActive2 = true;
			}	
			else if (isActive2 == true) {
				machineTwoBtn.setBackground(new JButton().getBackground());
				isActive2 = false;
			}
		}

		// handle 'machine 3' button click
		if (e.getSource() == machineThreeBtn)
		{
			if (isActive3 == false) {
				machineThreeBtn.setBackground(Color.gray);
				isActive3 = true;
			}	
			else if (isActive3 == true) {
				machineThreeBtn.setBackground(new JButton().getBackground());
				isActive3 = false;
			}
		}
		
		// handle 'submit' button click
		else if (e.getSource() == submitBtn)
		{
			batchIdValueString = batchText.getText();
			machineNumValueString = (String) machineText.getSelectedItem();
			bubbleCountValueString = bubbleText.getText();
			dateTime = getDateTimeStamp(); // gets date/time stamp when submit is pressed
					
			boolean bId = validateBatchId(batchIsValid);
			boolean mNum = validateMachineNum(machineText.getSelectedIndex());
			boolean bCount = validateBubbleCount(bubbleIsValid);
			
			// check if form fields are valid then do stuff...
			if (bId == true && mNum == true && bCount == true) {
				batchId = Integer.parseInt(batchIdValueString);
				machineNumber = Integer.parseInt(machineNumValueString);
				bubbleCount = Integer.parseInt(bubbleCountValueString);
				
				// create JSON for form data and add contents 
//				JSONObject data = new JSONObject();
//				data.put("batch_id", batchId);
//				data.put("machine_number", machineNumber);
//				data.put("bubble_count", bubbleCount);
//				data.put("date_time", dateTime);
				
				
				
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
	
	public String getDateTimeStamp() {
		final LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String datetime = currentDateTime.format(formatter);
		// System.out.println("datetime: " + datetime);
		return datetime;
	}
}	
	

