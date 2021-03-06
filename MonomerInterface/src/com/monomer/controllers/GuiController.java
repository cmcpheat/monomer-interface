package com.monomer.controllers;

// Class builds GUI and controls data transferred between models and views

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
import com.monomer.views.create_record.layouts.CRAlertLayout;
import com.monomer.views.create_record.layouts.CRButtonLayout;
import com.monomer.views.create_record.layouts.CRInputLayout;
import com.monomer.views.create_record.layouts.CRLabelLayout;
import com.monomer.views.live_data.components.ChartPanel;
import com.monomer.views.live_data.components.DataTable;
import com.monomer.views.live_data.components.DateFilter;
import com.monomer.views.live_data.components.MachineOneButton;
import com.monomer.views.live_data.components.MachineThreeButton;
import com.monomer.views.live_data.components.MachineTwoButton;
import com.monomer.views.live_data.layouts.LDButtonLayout;
import com.monomer.views.live_data.layouts.LDPanelLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GuiController {
	
	// GUI elements
	private JFrame frame;
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
	private JPanel liveDataPage;
	private GridBagConstraints buttonLayout;
	private GridBagConstraints panelLayout;
	private JComboBox<String> dateFilter;
	private JButton machineOneButton;
	private JButton machineTwoButton;
	private JButton machineThreeButton;
	private JPanel chartPanel;
	private JTable table;
	private DefaultTableModel model;
	private JTableHeader header;
	private JScrollPane scroll;
	private JScrollBar bar;
	private boolean machineOneActive = false;
	private boolean machineTwoActive = false;
	private boolean machineThreeActive = false;
	
	// Models
	private BatchIdModel bim;
	private BubbleCountModel bcm;
	private MachineNumberModel mnm;
	private DateTimeModel dtm;
	private SearchController sc;
	private CustomEventHandler customEventHandler;

	// set to "prod" for production
	// or "test" for test mode
	private String mode = "test";
	
	// GUI constructor 
	public GuiController() {		
		
		System.out.println("Running in " + mode + " mode...");
	
		// custom event handler for buttons etc.
		customEventHandler = new CustomEventHandler();
		sc = new SearchController();
		
		bim = new BatchIdModel();
		bcm = new BubbleCountModel();
		mnm = new MachineNumberModel();
		dtm = new DateTimeModel();
		
		// frame setup
		frame = new JFrame();
		frame.setResizable(false); // prevents resizing
		Dimension frameSize = new Dimension(1000, 700);
		frame.setPreferredSize(frameSize);

		// custom window close handler
		WindowListener exitListener = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(
						null, "Are you sure you want to quit?", 
						"Warning", JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, null, null);
						if (confirm == 0) {
							// user selects yes - quit
							System.exit(0);
						}
						else {
							// do nothing - just close dialog
						}
			}
		};	
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // override default window close
		frame.addWindowListener(exitListener); // custom window close event
		frame.setTitle("Monomer Data");
		
		// create tabs
		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(0,0,0,0);
		
		// create pages		
		liveDataPage = new JPanel(new GridBagLayout());
		
		// set styling for layout
		buttonLayout = new LDButtonLayout().setLiveDataButtonLayout();
		panelLayout = new LDPanelLayout().setLiveDataPanelLayout();
		
		// add 'machine 1' button
		machineOneButton = new MachineOneButton().setLiveDataMachineOneButton();
		machineOneButton.addActionListener(customEventHandler);
		machineOneButton.setFocusPainted(false);
		buttonLayout.gridx = 1;
		liveDataPage.add(machineOneButton, buttonLayout);
		
		// add 'machine 2' button
		machineTwoButton = new MachineTwoButton().setLiveDataMachineTwoButton();
		machineTwoButton.addActionListener(customEventHandler);
		machineTwoButton.setFocusPainted(false);
		buttonLayout.gridx = 2;
		liveDataPage.add(machineTwoButton, buttonLayout);
		 
		// add 'machine 3' button
		machineThreeButton = new MachineThreeButton().setLiveDataMachineThreeButton();
		machineThreeButton.addActionListener(customEventHandler);
		machineThreeButton.setFocusPainted(false);
		buttonLayout.gridx = 3;
		liveDataPage.add(machineThreeButton, buttonLayout);
		
		// add date filter drop-down
		dateFilter = new DateFilter().setDateFilter();
		dateFilter.addActionListener(customEventHandler);
		dateFilter.setFocusable(false);
		buttonLayout.gridx = 0;
		liveDataPage.add(dateFilter, buttonLayout);
 
		// add panel for line chart
		chartPanel = new ChartPanel().setLiveDataChartPanel();
		liveDataPage.add(chartPanel, panelLayout);
		
		// add table model
		model = new DataTable().setDataTable();
		table = new JTable(model);
	    table.getColumnModel().getColumn(0).setPreferredWidth(120);
	    table.getColumnModel().getColumn(1).setPreferredWidth(120);
	    table.getColumnModel().getColumn(2).setPreferredWidth(120);
	    table.getColumnModel().getColumn(3).setPreferredWidth(200);
	    table.setFont(new Font("", Font.PLAIN, 12));
	    table.setBackground(Color.white);
	    header = table.getTableHeader();
		header.setFont(new Font("", Font.BOLD, 12));
		chartPanel.add(header, BorderLayout.NORTH);
		chartPanel.add(table, BorderLayout.CENTER);
		scroll = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bar = scroll.getVerticalScrollBar();
		bar.setPreferredSize(new Dimension(10,0));
		chartPanel.add(scroll, panelLayout);
		
		// initialise table with data from files
		FileController fc = new FileController();
		ArrayList<String> batches = null;
		ArrayList<String> machines = null;
		ArrayList<String> bubbles = null;
		ArrayList<String> dates = null;
		try {
			
			if (mode == "prod") {
				batches = fc.readFromFile(mode, "batch_ids");
				machines = fc.readFromFile(mode, "machine_numbers");
				bubbles = fc.readFromFile(mode, "bubble_counts");
				dates = fc.readFromFile(mode, "date_times");
			}
			
			else if (mode == "test") {
				batches = fc.readFromFile(mode, "batch_ids");
				machines = fc.readFromFile(mode, "machine_numbers");
				bubbles = fc.readFromFile(mode, "bubble_counts");
				dates = fc.readFromFile(mode, "date_times");
			}
			
			updateTable(batches, machines, bubbles, dates);
			
			// initialise array lists with data from files
			for (int i = 0; i < batches.size(); i++) {
				
				bim.getBatchIdList().add(batches.get(i));
				mnm.getMachineNumberList().add(machines.get(i));
				bcm.getBubbleCountList().add(bubbles.get(i));
				dtm.getDateTimeList().add(dates.get(i));
			}
		}
		catch (Exception fe) {
			System.out.println("Error loading data from files.");
		}

		// add the 'create a record' page
		createRecordPage = new JPanel(); 
		
		// set layout for components
		GridBagConstraints labelLayout = new CRLabelLayout().setLabelLayout(); // done
		GridBagConstraints buttonLayout = new CRButtonLayout().setCreateRecordButtonLayout(); // done
		GridBagConstraints inputLayout = new CRInputLayout().setInputLayout(); // done
		GridBagConstraints alertLayout = new CRAlertLayout().setAlertLayout(); // done
		
		// add form panel to page
		formPanel = new FormPanel().setFormPanel();
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
		cancelButton.addActionListener(customEventHandler);
		cancelButton.setFocusPainted(false);
		buttonLayout.gridx = 0;
		formPanel.add(cancelButton, buttonLayout);
		
		// add 'submit' button to form
		submitButton = new SubmitButton().setSubmitButton();
		submitButton.addActionListener(customEventHandler);
		submitButton.setFocusPainted(false);
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
		
		// add pages to tabs
		tabs.add("Live Data", liveDataPage);
		tabs.add("Create a Record", createRecordPage);
		frame.add(tabs);
		
		// show GUI
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); // centres the window	
	}
		
	// handle button clicks etc
	private class CustomEventHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			// handle 'submit' button click
			if (e.getSource() == submitButton)
			{					
				LocalDateTime datetime = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				
				String BATCH_ID = batchIdInput.getText();
				String MACHINE_NUM = (String) machineNumberInput.getSelectedItem();
				String BUBBLE_COUNT = bubbleCountInput.getText();
				String DATE_TIME = datetime.format(formatter);
				
				// validate the strings
				// booleans are updated to be true (for valid) and false (for invalid)
				boolean batchValid = validateBatchId(BATCH_ID);
				boolean machineValid = validateMachineNum(machineNumberInput.getSelectedIndex());
				boolean bubbleValid = validateBubbleCount(BUBBLE_COUNT);
				
				// check if form fields are valid then do stuff...
				if (batchValid == true && machineValid == true && bubbleValid == true) {
								
					try
					{
						// add data to array lists
						
						bim.getBatchIdList().add(BATCH_ID);
						mnm.getMachineNumberList().add(MACHINE_NUM);
						bcm.getBubbleCountList().add(BUBBLE_COUNT);
						dtm.getDateTimeList().add(DATE_TIME);
						
						FileController fc = new FileController();
						fc.saveToFile(BATCH_ID, "batch_ids", mode);
						fc.saveToFile(MACHINE_NUM, "machine_numbers", mode);
						fc.saveToFile(BUBBLE_COUNT, "bubble_counts", mode);
						fc.saveToFile(DATE_TIME, "date_times", mode);	
						
						// show confirmation to user
						showSubmitMessage(BATCH_ID);

						model.insertRow(0, new Object[] {BATCH_ID, MACHINE_NUM, BUBBLE_COUNT, DATE_TIME});
					}
					catch (Exception exc)
					{
						// error shown if exception is caught 
						dataSubmittedLabel.setText("There has been an error. Please try again.");
						exc.printStackTrace(System.out);
					}
					// clear all fields after form submitted
					clearForm();
				}
			}
			
			// handle 'clear' button click
			else if (e.getSource() == cancelButton) {
				clearForm();
				submitButton.setEnabled(true);
			}
			
			// handle 'machine 1' button click
			else if (e.getSource() == machineOneButton)
			{
				if (machineOneActive == false) {
					machineOneButton.setBackground(Color.white);
										
					// disable button while data is processed
					machineOneButton.setEnabled(false);
					machineTwoButton.setEnabled(false);
					machineThreeButton.setEnabled(false);
					
					// set Live Data table to view all data
					dateFilter.setSelectedItem("View All...");
					dateFilter.setEnabled(false);
					
					// only show machine 1 data - catch any errors
					try {
					
						sc= new SearchController();
						ArrayList<Integer> M1_INDEXES = new ArrayList<Integer>();
						M1_INDEXES = sc.linearSearchForIndexes(mnm.getMachineNumberList(), 1);
						ArrayList<String> M1_BATCH = sc.arrayLinearSearch(M1_INDEXES, bim.getBatchIdList());
						ArrayList<String> M1_MACHINE = sc.arrayLinearSearch(M1_INDEXES, mnm.getMachineNumberList());
						ArrayList<String> M1_BUBBLE = sc.arrayLinearSearch(M1_INDEXES, bcm.getBubbleCountList());
						ArrayList<String> M1_DATE = sc.arrayLinearSearch(M1_INDEXES, dtm.getDateTimeList());
						
						updateTable(M1_BATCH, M1_MACHINE, M1_BUBBLE, M1_DATE);
						
					} catch (Exception e1) {
						machineOneButton.setEnabled(true);
						machineTwoButton.setEnabled(true);
						machineThreeButton.setEnabled(true);
						dateFilter.setEnabled(true);
						e1.printStackTrace();
					}
					
					// enable button 
					machineOneActive = true;
					machineOneButton.setEnabled(true);
				}	
				
				else if (machineOneActive == true) {
					machineOneButton.setBackground(new JButton().getBackground());
					
					// disable button while data is processed
					machineOneButton.setEnabled(false);
					
					ArrayList<String> ALL_BATCH = bim.getBatchIdList();
					ArrayList<String> ALL_MACHINE = mnm.getMachineNumberList();
					ArrayList<String> ALL_BUBBLE = bcm.getBubbleCountList();
					ArrayList<String> ALL_DATE = dtm.getDateTimeList();
					
					updateTable(ALL_BATCH, ALL_MACHINE, ALL_BUBBLE, ALL_DATE);
					
					machineOneActive = false;
					machineOneButton.setEnabled(true);
					machineTwoButton.setEnabled(true);
					machineThreeButton.setEnabled(true);
					dateFilter.setEnabled(true);
				}
			}
			
			// handle 'machine 2' button click
			else if (e.getSource() == machineTwoButton)
			{
				if (machineTwoActive == false) {
					machineTwoButton.setBackground(Color.white);
										
					// disable button while data is processed
					machineTwoButton.setEnabled(false);
					machineOneButton.setEnabled(false);
					machineThreeButton.setEnabled(false);
					
					// set Live Data table to view all data
					dateFilter.setSelectedItem("View All...");
					dateFilter.setEnabled(false);
					
					// only show machine 2 data - catch any errors
					try {
					
						sc = new SearchController();
						ArrayList<Integer> INDEXES = sc.linearSearchForIndexes(mnm.getMachineNumberList(), 2);
					
						ArrayList<String> M2_BATCH = sc.arrayLinearSearch(INDEXES, bim.getBatchIdList());
						ArrayList<String> M2_MACHINE = sc.arrayLinearSearch(INDEXES, mnm.getMachineNumberList());
						ArrayList<String> M2_BUBBLE = sc.arrayLinearSearch(INDEXES, bcm.getBubbleCountList());
						ArrayList<String> M2_DATE = sc.arrayLinearSearch(INDEXES, dtm.getDateTimeList());
						
						updateTable(M2_BATCH, M2_MACHINE, M2_BUBBLE, M2_DATE);
						
					} catch (Exception e1) {
						e1.printStackTrace();
						machineOneButton.setEnabled(true);
						machineTwoButton.setEnabled(true);
						machineThreeButton.setEnabled(true);
						dateFilter.setEnabled(true);
					}
					
					// enable button 
					machineTwoActive = true;
					machineTwoButton.setEnabled(true);
					
				}	
				else if (machineTwoActive == true) {
					machineTwoButton.setBackground(new JButton().getBackground());
					
					// disable button while data is processed
					machineTwoButton.setEnabled(false);
					
					ArrayList<String> ALL_BATCH = bim.getBatchIdList();
					ArrayList<String> ALL_MACHINE = mnm.getMachineNumberList();
					ArrayList<String> ALL_BUBBLE = bcm.getBubbleCountList();
					ArrayList<String> ALL_DATE = dtm.getDateTimeList();
					
					updateTable(ALL_BATCH, ALL_MACHINE, ALL_BUBBLE, ALL_DATE);
					
					machineTwoActive = false;
					machineTwoButton.setEnabled(true);
					machineThreeButton.setEnabled(true);
					machineOneButton.setEnabled(true);
					dateFilter.setEnabled(true);
				}
			}
			
			// handle 'machine 3' button click
			else if (e.getSource() == machineThreeButton)
			{
				if (machineThreeActive == false) {
					machineThreeButton.setBackground(Color.white);
										
					// disable button while data is processed
					machineThreeButton.setEnabled(false);
					machineTwoButton.setEnabled(false);
					machineOneButton.setEnabled(false);

					// set Live Data table to view all data
					dateFilter.setSelectedItem("View All...");
					dateFilter.setEnabled(false);
					
					// only show machine 3 data - catch any errors
					try {
					
						sc = new SearchController();
						ArrayList<Integer> INDEXES = sc.linearSearchForIndexes(mnm.getMachineNumberList(), 3);
											
						ArrayList<String> M3_BATCH = sc.arrayLinearSearch(INDEXES, bim.getBatchIdList());
						ArrayList<String> M3_MACHINE = sc.arrayLinearSearch(INDEXES, mnm.getMachineNumberList());
						ArrayList<String> M3_BUBBLE = sc.arrayLinearSearch(INDEXES, bcm.getBubbleCountList());
						ArrayList<String> M3_DATE = sc.arrayLinearSearch(INDEXES, dtm.getDateTimeList());
						
						updateTable(M3_BATCH, M3_MACHINE, M3_BUBBLE, M3_DATE);
						
					} catch (Exception e1) {
						e1.printStackTrace();
						machineOneButton.setEnabled(true);
						machineTwoButton.setEnabled(true);
						machineThreeButton.setEnabled(true);
						dateFilter.setEnabled(true);
					}
					
					// enable button 
					machineThreeActive = true;
					machineThreeButton.setEnabled(true);
					
				}	
				else if (machineThreeActive == true) {
					machineThreeButton.setBackground(new JButton().getBackground());
					
					// disable button while data is processed
					machineThreeButton.setEnabled(false);
					
					ArrayList<String> ALL_BATCH = bim.getBatchIdList();
					ArrayList<String> ALL_MACHINE = mnm.getMachineNumberList();
					ArrayList<String> ALL_BUBBLE = bcm.getBubbleCountList();
					ArrayList<String> ALL_DATE = dtm.getDateTimeList();
					
					updateTable(ALL_BATCH, ALL_MACHINE, ALL_BUBBLE, ALL_DATE);
					
					machineThreeActive = false;
					machineThreeButton.setEnabled(true);
					machineTwoButton.setEnabled(true);
					machineOneButton.setEnabled(true);
					dateFilter.setEnabled(true);
				}
			}
			
			// handle date filter selection
			else if (e.getSource() == dateFilter)
			{
				if (dateFilter.getSelectedItem() == "View All...") {
					
					ArrayList<String> ALL_BATCH = bim.getBatchIdList();
					ArrayList<String> ALL_MACHINE = mnm.getMachineNumberList();
					ArrayList<String> ALL_BUBBLE = bcm.getBubbleCountList();
					ArrayList<String> ALL_DATE = dtm.getDateTimeList();
					
					updateTable(ALL_BATCH, ALL_MACHINE, ALL_BUBBLE, ALL_DATE);		
				}
				
				
				else if (dateFilter.getSelectedItem() == "Last Hour") {
		
					// get all data within last hour and update table
					ArrayList<Integer> dateTimeIndexes = new ArrayList<Integer>();
					dateTimeIndexes = sc.dateRangeSearch(dtm.getDateTimeList(), "last hour");
					
					ArrayList<String> batch = sc.arrayLinearSearch(dateTimeIndexes, bim.getBatchIdList());
					ArrayList<String> machine = sc.arrayLinearSearch(dateTimeIndexes, mnm.getMachineNumberList());
					ArrayList<String> bubble = sc.arrayLinearSearch(dateTimeIndexes, bcm.getBubbleCountList());
					ArrayList<String> date = sc.arrayLinearSearch(dateTimeIndexes, dtm.getDateTimeList());

					updateTable(batch, machine, bubble, date);
				}	
				else if (dateFilter.getSelectedItem() == "Last 24 Hours") {
					
					// get all data within last 24 hourS and update table
					ArrayList<Integer> dateTimeIndexes = new ArrayList<Integer>();
					dateTimeIndexes = sc.dateRangeSearch(dtm.getDateTimeList(), "last 24 hours");
					
					ArrayList<String> batch = sc.arrayLinearSearch(dateTimeIndexes, bim.getBatchIdList());
					ArrayList<String> machine = sc.arrayLinearSearch(dateTimeIndexes, mnm.getMachineNumberList());
					ArrayList<String> bubble = sc.arrayLinearSearch(dateTimeIndexes, bcm.getBubbleCountList());
					ArrayList<String> date = sc.arrayLinearSearch(dateTimeIndexes, dtm.getDateTimeList());
	
					updateTable(batch, machine, bubble, date);					
				}
				else if (dateFilter.getSelectedItem() == "Last 7 Days") {
				
					// get all data within last 7 days and update table
					ArrayList<Integer> dateTimeIndexes = new ArrayList<Integer>();
					dateTimeIndexes = sc.dateRangeSearch(dtm.getDateTimeList(), "last 7 days");
					
					ArrayList<String> batch = sc.arrayLinearSearch(dateTimeIndexes, bim.getBatchIdList());
					ArrayList<String> machine = sc.arrayLinearSearch(dateTimeIndexes, mnm.getMachineNumberList());
					ArrayList<String> bubble = sc.arrayLinearSearch(dateTimeIndexes, bcm.getBubbleCountList());
					ArrayList<String> date = sc.arrayLinearSearch(dateTimeIndexes, dtm.getDateTimeList());

					updateTable(batch, machine, bubble, date);
				}
				else if (dateFilter.getSelectedItem() == "Last 30 Days") {
					
					// get all data within last 30 days and update table
					ArrayList<Integer> dateTimeIndexes = new ArrayList<Integer>();
					dateTimeIndexes = sc.dateRangeSearch(dtm.getDateTimeList(), "last 30 days");
					
					ArrayList<String> batch = sc.arrayLinearSearch(dateTimeIndexes, bim.getBatchIdList());
					ArrayList<String> machine = sc.arrayLinearSearch(dateTimeIndexes, mnm.getMachineNumberList());
					ArrayList<String> bubble = sc.arrayLinearSearch(dateTimeIndexes, bcm.getBubbleCountList());
					ArrayList<String> date = sc.arrayLinearSearch(dateTimeIndexes, dtm.getDateTimeList());

					updateTable(batch, machine, bubble, date);
				}
			}
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
			boolean used = sc.batchIdBinarySearch(bim.getBatchIdList(), i);
			if (used == true)
			{
				batchIdAlertLabel.setText("Batch ID already exists. Please try again.");
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
	public void showSubmitMessage (String s) {
		dataSubmittedLabel.setText("Batch #" + s + " data has been submitted successfully.");
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
		catch (Exception ex) {
			dataSubmittedLabel.setText(" ");
			ex.printStackTrace(System.out);
		}
	}
	
	// clears all fields on form
	public void clearForm() {
		batchIdInput.setText("");
		batchIdAlertLabel.setText(" ");
		machineNumberInput.setSelectedIndex(0);
		machineNumberAlertLabel.setText(" ");
		bubbleCountInput.setText("");
		bubbleCountAlertLabel.setText(" ");
	}
	
	// get current time
	public LocalDateTime getDateTimeNow() {
		final LocalDateTime now = LocalDateTime.now();
		return now;
	}
	
	// get the earliest date in the range selected by user
	public LocalDateTime getEarliestDate(int range) {
			
		LocalDateTime result = null;

		switch (range) {
			// get last hour
			case 1:
				result = LocalDateTime.now().minusHours(1);
				return result;
			// get last 24 hours
			case 24:
				result = LocalDateTime.now().minusHours(24);
				return result;
			// get last 7 days
			case 7:
				result = LocalDateTime.now().minusDays(7);
				return result;
			// get last 30 days
			case 30:
				result = LocalDateTime.now().minusDays(30);
				return result;
			}
		return result;
	}
	
	// update the table with array lists
	public void updateTable(ArrayList<String> batch, ArrayList<String> machine, 
			ArrayList<String> bubble, ArrayList<String> date) {
		try {
			// update table or catch any errors
			model.setRowCount(0);
			
			for (int i = 0; i < batch.size(); i++) {
				
				String BA = batch.get(i);
				String MN = machine.get(i);
				String BC = bubble.get(i);
				String DT = date.get(i);
				
				model.insertRow(0, new Object[] { BA, MN, BC, DT });
			}
		}
		catch (Exception exc) {
			exc.printStackTrace(System.out);
		}
	}
}	


	
