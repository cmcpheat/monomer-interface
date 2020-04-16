package com.monomer.controllers;

// import com.monomer.app.Singleton;
// import com.monomer.controllers.GuiFunctionController;
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
// import com.monomer.views.live_data.components.DataTable;
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
	
	private BatchIdController batchIdController;
	private BubbleCountController bubbleCountController;
	private MachineNumberController machineNumberController;
	private DateTimeController dateTimeController;
	private CustomEventHandler customEventHandler;

	// GUI constructor 
	public GuiController() {
		
		// custom event handler for buttons etc.
		customEventHandler = new CustomEventHandler();
		
		batchIdController = new BatchIdController();
		bubbleCountController = new BubbleCountController();
		machineNumberController = new MachineNumberController();
		dateTimeController = new DateTimeController();
		
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
						null, "Are you sure you want to exit?\n"
								+ "Your information will be lost\n"
								+ "when the app closes.", 
						"Confirm Exit", JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, null, null);
						if (confirm == 0) {
							
							ArrayList<String> batchSaveList = batchIdController.getBatchIdList();
							ArrayList<String> bubbleSaveList = bubbleCountController.getBubbleCountList();	
							ArrayList<String> machineSaveList = machineNumberController.getMachineNumberList();	
							ArrayList<String> dateSaveList = dateTimeController.getDateTimeList();	
							
							FileController fc = new FileController();
							fc.saveToFile(batchSaveList, "batch_ids");
							fc.saveToFile(bubbleSaveList, "bubble_counts");
							fc.saveToFile(machineSaveList, "machine_numbers");
							fc.saveToFile(dateSaveList, "date_times");
							
							System.out.println(batchSaveList);
							System.out.println(bubbleSaveList);
							System.out.println(machineSaveList);
							System.out.println(dateSaveList);
							
							System.exit(0);
						}
			}
		};	
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // allows processes to end before quitting 
		frame.addWindowListener(exitListener);
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
		bar.setPreferredSize(new Dimension(40,0));
		
		chartPanel.add(scroll, panelLayout);
		
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
				
				LocalDateTime datetime = LocalDateTime.now().plusHours(1);
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
						
						batchIdController.getBatchIdList().add(BATCH_ID);
						machineNumberController.getMachineNumberList().add(MACHINE_NUM);
						bubbleCountController.getBubbleCountList().add(BUBBLE_COUNT);
						dateTimeController.getDateTimeList().add(DATE_TIME);
						
						// show confirmation to user
						showSubmitMessage(BATCH_ID);
						
//						System.out.println("batch:   " + batchIdController.getBatchIdList());
//						System.out.println("machine: " + machineNumberController.getMachineNumberList());
//						System.out.println("bubble:  " + bubbleCountController.getBubbleCountList());
//						System.out.println("date:    " + dateTimeController.getDateTimeList());
						
						
						model.insertRow(0, new Object[] {BATCH_ID, MACHINE_NUM,BUBBLE_COUNT, DATE_TIME});
					}
					catch (Exception exc)
					{
						// error shown if exception is caught 
						dataSubmittedLabel.setText("There has been an error. Please try again.");
						exc.printStackTrace(System.out);
					}
					
					// delete all fields
					clearForm();


				}
			}
			
			// handle 'clear' button click
			else if (e.getSource() == cancelButton) {
				System.out.println("batch:   " + batchIdController.getBatchIdList());
				System.out.println("machine: " + machineNumberController.getMachineNumberList());
				System.out.println("bubble:  " + bubbleCountController.getBubbleCountList());
				System.out.println("date:    " + dateTimeController.getDateTimeList());
				clearForm();

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
					
					// only show machine 1 data - catch any errors
					try {
					
						LinearSearchController linear = new LinearSearchController();
						ArrayList<Integer> INDEXES = linear.linearSearchForIndexes(machineNumberController.getMachineNumberList(), "1");
						System.out.println(INDEXES);
						
						ArrayList<String> M1_BATCH = LinearSearchController.arrayLinearSearch(INDEXES, batchIdController.getBatchIdList());
						ArrayList<String> M1_MACHINE = LinearSearchController.arrayLinearSearch(INDEXES, machineNumberController.getMachineNumberList());
						ArrayList<String> M1_BUBBLE = LinearSearchController.arrayLinearSearch(INDEXES, bubbleCountController.getBubbleCountList());
						ArrayList<String> M1_DATE = LinearSearchController.arrayLinearSearch(INDEXES, dateTimeController.getDateTimeList());
						
						System.out.println(M1_BATCH);
						System.out.println(M1_MACHINE);
						System.out.println(M1_BUBBLE);
						System.out.println(M1_DATE);
						
						// TODO getting the values but need to add to table line by line
						
						model.setRowCount(0);
						
						for (int i = 0; i < M1_BATCH.size(); i++) {
							
							String BA = M1_BATCH.get(i);
							String MN = M1_MACHINE.get(i);
							String BC = M1_BUBBLE.get(i);
							String DT = M1_DATE.get(i);
							
							model.insertRow(0, new Object[] { BA, MN, BC, DT });	
						}
						
					} catch (Exception e1) {
						machineOneButton.setEnabled(true);
						machineTwoButton.setEnabled(true);
						machineThreeButton.setEnabled(true);
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
					
					ArrayList<String> ALL_BATCH = batchIdController.getBatchIdList();
					ArrayList<String> ALL_MACHINE = machineNumberController.getMachineNumberList();
					ArrayList<String> ALL_BUBBLE = bubbleCountController.getBubbleCountList();
					ArrayList<String> ALL_DATE = dateTimeController.getDateTimeList();
					
					model.setRowCount(0);
					
					for (int i = 0; i < ALL_BATCH.size(); i++) {
						
						String BA = ALL_BATCH.get(i);
						String MN = ALL_MACHINE.get(i);
						String BC = ALL_BUBBLE.get(i);
						String DT = ALL_DATE.get(i);
						
						model.insertRow(0, new Object[] { BA, MN, BC, DT });	
					}
					
					machineOneActive = false;
					machineOneButton.setEnabled(true);
					machineTwoButton.setEnabled(true);
					machineThreeButton.setEnabled(true);
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
					
					// only show machine 2 data - catch any errors
					try {
					
						LinearSearchController linear = new LinearSearchController();
						ArrayList<Integer> INDEXES = linear.linearSearchForIndexes(machineNumberController.getMachineNumberList(), "2");
						System.out.println(INDEXES);
						
						ArrayList<String> M2_BATCH = LinearSearchController.arrayLinearSearch(INDEXES, batchIdController.getBatchIdList());
						ArrayList<String> M2_MACHINE = LinearSearchController.arrayLinearSearch(INDEXES, machineNumberController.getMachineNumberList());
						ArrayList<String> M2_BUBBLE = LinearSearchController.arrayLinearSearch(INDEXES, bubbleCountController.getBubbleCountList());
						ArrayList<String> M2_DATE = LinearSearchController.arrayLinearSearch(INDEXES, dateTimeController.getDateTimeList());
						
						System.out.println(M2_BATCH);
						System.out.println(M2_MACHINE);
						System.out.println(M2_BUBBLE);
						System.out.println(M2_DATE);
						
						// TODO getting the values but need to add to table line by line
						
						model.setRowCount(0);
						
						for (int i = 0; i < M2_BATCH.size(); i++) {
							
							String BA = M2_BATCH.get(i);
							String MN = M2_MACHINE.get(i);
							String BC = M2_BUBBLE.get(i);
							String DT = M2_DATE.get(i);
							
							model.insertRow(0, new Object[] { BA, MN, BC, DT });	
						}
						
					} catch (Exception e1) {
						e1.printStackTrace();
						machineOneButton.setEnabled(true);
						machineTwoButton.setEnabled(true);
						machineThreeButton.setEnabled(true);
					}
					
					// enable button 
					machineTwoActive = true;
					machineTwoButton.setEnabled(true);
					
				}	
				else if (machineTwoActive == true) {
					machineTwoButton.setBackground(new JButton().getBackground());
					
					// disable button while data is processed
					machineTwoButton.setEnabled(false);
					
					ArrayList<String> ALL_BATCH = batchIdController.getBatchIdList();
					ArrayList<String> ALL_MACHINE = machineNumberController.getMachineNumberList();
					ArrayList<String> ALL_BUBBLE = bubbleCountController.getBubbleCountList();
					ArrayList<String> ALL_DATE = dateTimeController.getDateTimeList();
					
					model.setRowCount(0);
					
					for (int i = 0; i < ALL_BATCH.size(); i++) {
						
						String BA = ALL_BATCH.get(i);
						String MN = ALL_MACHINE.get(i);
						String BC = ALL_BUBBLE.get(i);
						String DT = ALL_DATE.get(i);
						
						model.insertRow(0, new Object[] { BA, MN, BC, DT });	
					}
					
					machineTwoActive = false;
					machineTwoButton.setEnabled(true);
					machineThreeButton.setEnabled(true);
					machineOneButton.setEnabled(true);
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
					
					// only show machine 3 data - catch any errors
					try {
					
						LinearSearchController linear = new LinearSearchController();
						ArrayList<Integer> INDEXES = linear.linearSearchForIndexes(machineNumberController.getMachineNumberList(), "3");
						System.out.println(INDEXES);
						
						ArrayList<String> M3_BATCH = LinearSearchController.arrayLinearSearch(INDEXES, batchIdController.getBatchIdList());
						ArrayList<String> M3_MACHINE = LinearSearchController.arrayLinearSearch(INDEXES, machineNumberController.getMachineNumberList());
						ArrayList<String> M3_BUBBLE = LinearSearchController.arrayLinearSearch(INDEXES, bubbleCountController.getBubbleCountList());
						ArrayList<String> M3_DATE = LinearSearchController.arrayLinearSearch(INDEXES, dateTimeController.getDateTimeList());
						
						System.out.println(M3_BATCH);
						System.out.println(M3_MACHINE);
						System.out.println(M3_BUBBLE);
						System.out.println(M3_DATE);
						
						// TODO getting the values but need to add to table line by line
						
						model.setRowCount(0);
						
						for (int i = 0; i < M3_BATCH.size(); i++) {
							
							String BA = M3_BATCH.get(i);
							String MN = M3_MACHINE.get(i);
							String BC = M3_BUBBLE.get(i);
							String DT = M3_DATE.get(i);
							
							model.insertRow(0, new Object[] { BA, MN, BC, DT });	
						}
						
					} catch (Exception e1) {
						e1.printStackTrace();
						machineOneButton.setEnabled(true);
						machineTwoButton.setEnabled(true);
						machineThreeButton.setEnabled(true);
					}
					
					// enable button 
					machineThreeActive = true;
					machineThreeButton.setEnabled(true);
					
					// model.insertRow(0, new Object[] { BATCH_VALUES, MACHINE_VALUES, BUBBLE_VALUES, DATE_VALUES });
					
				}	
				else if (machineThreeActive == true) {
					machineThreeButton.setBackground(new JButton().getBackground());
					
					// disable button while data is processed
					machineThreeButton.setEnabled(false);
					
					ArrayList<String> ALL_BATCH = batchIdController.getBatchIdList();
					ArrayList<String> ALL_MACHINE = machineNumberController.getMachineNumberList();
					ArrayList<String> ALL_BUBBLE = bubbleCountController.getBubbleCountList();
					ArrayList<String> ALL_DATE = dateTimeController.getDateTimeList();
					
					model.setRowCount(0);
					
					for (int i = 0; i < ALL_BATCH.size(); i++) {
						
						String BA = ALL_BATCH.get(i);
						String MN = ALL_MACHINE.get(i);
						String BC = ALL_BUBBLE.get(i);
						String DT = ALL_DATE.get(i);
						
						model.insertRow(0, new Object[] { BA, MN, BC, DT });	
					}
					
					machineThreeActive = false;
					machineThreeButton.setEnabled(true);
					machineTwoButton.setEnabled(true);
					machineOneButton.setEnabled(true);
				}
			}
			
			// handle date filter selection
			else if (e.getSource() == dateFilter)
			{
				if (dateFilter.getSelectedItem() == "Last Hour") {
					//System.out.println("last hour test");
					
					// now need to get all data that has date/time within last hour
					LocalDateTime now = getDateTimeNow().plusHours(1);
					LocalDateTime then = getEarliestDate(1);
					
					// get data in this time frame
		
					// takes in date selection
					// searches through the DATE_TIME_LIST for date selection
					// returns the list of array index numbers that are in that range
				  
					int count = 0;
					int col = 4;
					int cells = table.getRowCount() * 4;
					
					String s = (String)target.getValueAt()
					
					while (count < max) {
						
						if (list.get(index).isBefore(now) && list.get(index).isAfter(then)) {
							// System.out.println("DATE: " + list.get(index) + " is in range");
							LIST_OF_INDEXES.add(index);
						}
						else if (list.get(index).isBefore(then)) {
							// System.out.println("DATE: " + list.get(index) + " is out of range");
						}
						index++;
					}
					
					
					
					
				}	
				else if (dateFilter.getSelectedItem() == "Last 24 Hours") {
					//System.out.println("last 24 hours test");
					
					// now need to get all data that has date/time within last 24 hours
					LocalDateTime now = getDateTimeNow().plusHours(1);
					LocalDateTime then = getEarliestDate(24);
					//System.out.println("time now: " + now);
					//System.out.println("24hr ago: " + then);
					
					// get data in this time frame

					
				}
				else if (dateFilter.getSelectedItem() == "Last 7 Days") {
					//System.out.println("last 7 days test");
					
					// now need to get all data that has date/time within last 7 days
					LocalDateTime now = getDateTimeNow().plusHours(1);
					LocalDateTime then = getEarliestDate(7);
					//System.out.println("time now: " + now);
					//System.out.println("7 dy ago: " + then);
					
					// get data in this time frame
					
				}
				else if (dateFilter.getSelectedItem() == "Last 30 Days") {
					//System.out.println("last 30 days test");
									
					LocalDateTime now = getDateTimeNow().plusHours(1);
					LocalDateTime then = getEarliestDate(30);
					//System.out.println("time now: " + now);
					//System.out.println("30 d ago: " + then);
					
					// get data in this time frame
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
	
	// deletes all fields on form
	public void clearForm() {
		batchIdInput.setText("");
		batchIdAlertLabel.setText(" ");
		machineNumberInput.setSelectedIndex(0);
		machineNumberAlertLabel.setText(" ");
		bubbleCountInput.setText("");
		bubbleCountAlertLabel.setText(" ");
	}
	
	// add data to table
	public void addDataToTable(String datas) {
		
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
	
}
	
