package com.monomer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class GUI implements ActionListener {
	
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
	private JLabel bubbleLabel;
	private JTextField batchText;
	private JComboBox<String> machineText;
	private JTextField bubbleText;
	private int batchId;
	private int machineNum;
	private int bubbleCount;
	private boolean isActive1 = false;
	private boolean isActive2 = false;
	private boolean isActive3 = false;
	// boolean selectionAllowed = true;

	// GUI constructor 
	public GUI() {
		
		// Frame set up
		mainFrame = new JFrame();
		mainFrame.setResizable(false); // prevents resizing
		Dimension frameSize = new Dimension(1000, 1000);
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
		formPanel.setBorder(BorderFactory.createEmptyBorder(100, 10, 10, 10));
		
		// batch ID label
		batchLabel = new JLabel("Batch ID");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 40;      //make this component tall
		c2.weightx = 0.5;
		c2.gridx = 0;
		c2.gridy = 0;
		c2.insets = new Insets(20,20,0,20);		
		formPanel.add(batchLabel, c2);
		
		// batch ID validation label // hidden by default
		batchValidationLabel = new JLabel("test", JLabel.CENTER);
		batchValidationLabel.setForeground(Color.red);
		batchValidationLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 1;
		c2.gridx = 1;
		c2.gridy = 1;
		formPanel.add(batchValidationLabel, c2);
		
		// machine no. label
		machineLabel = new JLabel("Machine Number");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 40;
		c2.weightx = 0.5;
		c2.gridx = 0;
		c2.gridy = 2;
		c2.insets = new Insets(0,20,20,20);
		formPanel.add(machineLabel, c2);
		 
		// bubble count label
		bubbleLabel = new JLabel("Bubble Count");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 40;
		c2.weightx = 0.5;
		c2.gridx = 0;
		c2.gridy = 4;
		c2.insets = new Insets(20,20,20,20);
		formPanel.add(bubbleLabel, c2);
		
//		// 'batch id' form validation
//		NumberFormat format = NumberFormat.getIntegerInstance();
//		format.setGroupingUsed(false);
//	    NumberFormatter batchIdValidate = new NumberFormatter(format);
//	    batchIdValidate.setValueClass(Integer.class);
//	    batchIdValidate.setMinimum(0);
//	    batchIdValidate.setMaximum(999999);
//	    batchIdValidate.setAllowsInvalid(false);
//	    // If you want the value to be committed on each keystroke instead of focus lost
//	    batchIdValidate.setCommitsOnValidEdit(true);
		
		// batch ID text input
		batchText = new JTextField("", 20);
		//batchText.setColumns(20);
		batchText.setBorder(BorderFactory.createCompoundBorder(
		batchText.getBorder(), 
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 20;      //make this component tall
		c2.weightx = 0.5;
		c2.gridx = 1;
		c2.gridy = 0;
		c2.insets = new Insets(20,20,0,20);		
		formPanel.add(batchText, c2);
		
		// machine no. drop down
		machineText = new JComboBox<String>();
		
		machineText.setBorder(BorderFactory.createCompoundBorder(
		machineText.getBorder(), 
        BorderFactory.createEmptyBorder(10, 10, 10, 0)));
		machineText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		machineText.setBackground(Color.white);
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 40;
		c2.weightx = 0.5;
		c2.gridx = 1;
		c2.gridy = 2;
		c2.insets = new Insets(0,20,0,20);
		formPanel.add(machineText, c2);
	    machineText.addItem("Please select...");
	    machineText.addItem("1");
		machineText.addItem("2");
		machineText.addItem("3");
		 
		// bubble count text input
		bubbleText = new JTextField("");
		bubbleText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					Integer.parseInt(bubbleText.getText());
					batchValidationLabel.setText("");
				} catch (NumberFormatException e1) {
					batchValidationLabel.setText("Invalid Batch ID, enter a number between 1-999999");
				}
			}
			
		});

		
		
		
		
		
		
		bubbleText.setBorder(BorderFactory.createCompoundBorder(
		bubbleText.getBorder(), 
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 20;
		c2.weightx = 1.5;
		c2.gridx = 1;
		c2.gridy = 4;
		c2.insets = new Insets(20,20,20,20);
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
				System.out.println("Machine 1 active");
				machineOneBtn.setBackground(Color.red);
				isActive1 = true;
			}	
			else if (isActive1 == true) {
				System.out.println("Machine 1 is NOT active");
				machineOneBtn.setBackground(Color.black);
				isActive1 = false;
			}
		}

		// handle 'machine 2' button click
		if (e.getSource() == machineTwoBtn)
		{
			if (isActive2 == false) {
				System.out.println("Machine 2 active");
				machineTwoBtn.setBackground(Color.green);
				isActive2 = true;
			}	
			else if (isActive2 == true) {
				System.out.println("Machine 2 is NOT active");
				machineTwoBtn.setBackground(Color.black);
				isActive2 = false;
			}
		}

		// handle 'machine 3' button click
		if (e.getSource() == machineThreeBtn)
		{
			if (isActive3 == false) {
				System.out.println("Machine 3 active");
				machineThreeBtn.setBackground(Color.yellow);
				isActive3 = true;
			}	
			else if (isActive3 == true) {
				System.out.println("Machine 3 is NOT active");
				machineThreeBtn.setBackground(Color.black);
				isActive3 = false;
			}
		}
		
		// handle 'submit' button click
		else if (e.getSource() == submitBtn)
		{
			System.out.println("Submit pressed");
			// validateForm(String.valueOf(batchText.getText()), String.valueOf(machineText.getSelectedItem()), String.valueOf(bubbleText.getText()));
			batchId = Integer.parseInt(String.valueOf(batchText.getText()));
//			machineNum = Integer.parseInt(String.valueOf(machineText.getSelectedItem()));
//			bubbleCount = Integer.parseInt(String.valueOf(bubbleText.getText()));
			// validateForm(batchId);
			System.out.println(batchId);
		}
		
		// handle 'clear' button click
		else if (e.getSource() == clearBtn) {
			System.out.println("Clear pressed");
			batchText.setText("");
			machineText.setSelectedIndex(0);
			bubbleText.setText("");
		}
	}

	public void validateForm(int batch) {
		System.out.println(batch);
		if (batch > 0 && batch <= 999999) {
			System.out.println("batch between 1-999999");
		} else {
			System.out.println("batch IS NOT between 1-999999");
		}
//		System.out.println(bubble);
//		System.out.println(machine);
		
	}
}
