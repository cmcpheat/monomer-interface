package com.monomer.views;

import com.monomer.controllers.BatchIdController;
import com.monomer.controllers.BubbleCountController;
import com.monomer.controllers.DateTimeController;
import com.monomer.controllers.MachineNumberController;
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
import com.monomer.views.create_record.layouts.AlertLayout;
import com.monomer.views.create_record.layouts.CreateRecordButtonLayout;
import com.monomer.views.create_record.layouts.InputLayout;
import com.monomer.views.create_record.layouts.LabelLayout;
import com.monomer.views.live_data.components.ChartPanel;
// import com.monomer.views.live_data.components.DataTable;
import com.monomer.views.live_data.components.DateFilter;
import com.monomer.views.live_data.components.MachineOneButton;
import com.monomer.views.live_data.components.MachineThreeButton;
import com.monomer.views.live_data.components.MachineTwoButton;
import com.monomer.views.live_data.layouts.LiveDataButtonLayout;
import com.monomer.views.live_data.layouts.PanelLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GUI {
	
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
	private boolean machineOneActive = false;
	private boolean machineTwoActive = false;
	private boolean machineThreeActive = false;
	
	private BatchIdController batchIdController;
	private BubbleCountController bubbleCountController;
	private MachineNumberController machineNumberController;
	private DateTimeController dateTimeController;
	private TheHandler handler;
	

	// GUI constructor 
	public GUI() {
		
		// Singleton tmp = Singleton.getInstance();
		
		handler = new TheHandler();
		batchIdController = new BatchIdController();
		bubbleCountController = new BubbleCountController();
		machineNumberController = new MachineNumberController();
		dateTimeController = new DateTimeController();
		
		// frame setup
		frame = new JFrame();
		frame.setResizable(false); // prevents resizing
		Dimension frameSize = new Dimension(1000, 700);
		frame.setPreferredSize(frameSize);
//		ImageIcon icon = new ImageIcon("/icon2.png");
//		frame.setIconImage(icon.getImage());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // allows processes to end before quitting 
		frame.setTitle("Monomer Data");
		
		// create tabs
		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(0,0,0,0);
		
		// create pages		
		liveDataPage = new JPanel(new GridBagLayout());
		
		// set styling for layout
		buttonLayout = new LiveDataButtonLayout().setLiveDataButtonLayout();
		panelLayout = new PanelLayout().setLiveDataPanelLayout();
		
		// add 'machine 1' button
		machineOneButton = new MachineOneButton().setLiveDataMachineOneButton();
		machineOneButton.addActionListener(handler);
		buttonLayout.gridx = 1;
		liveDataPage.add(machineOneButton, buttonLayout);
		
		// add 'machine 2' button
		machineTwoButton = new MachineTwoButton().setLiveDataMachineTwoButton();
		machineTwoButton.addActionListener(handler);
		buttonLayout.gridx = 2;
		liveDataPage.add(machineTwoButton, buttonLayout);
		 
		// add 'machine 3' button
		machineThreeButton = new MachineThreeButton().setLiveDataMachineThreeButton();
		machineThreeButton.addActionListener(handler);
		buttonLayout.gridx = 3;
		liveDataPage.add(machineThreeButton, buttonLayout);
		
		// add date filter drop-down
		dateFilter = new DateFilter().setDateFilter();
		dateFilter.addActionListener(handler);
		buttonLayout.gridx = 0;
		liveDataPage.add(dateFilter, buttonLayout);
 
		// add panel for line chart
		chartPanel = new ChartPanel().setLiveDataChartPanel();
		liveDataPage.add(chartPanel, panelLayout);
		
		// add table
		model = new DefaultTableModel();
		model.addColumn("Batch ID");
        model.addColumn("Machine No.");
        model.addColumn("Bubble Count");
        model.addColumn("Date");
        table = new JTable(model);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);  
        
        
		
		header = table.getTableHeader();
		// chartPanel.setLayout(new BorderLayout());
		chartPanel.add(header, BorderLayout.NORTH);
		chartPanel.add(table, BorderLayout.CENTER);
		
		JScrollPane sp=new JScrollPane(table); 
		
		chartPanel.add(sp, panelLayout);
		
		// add the 'create a record' page
		createRecordPage = new JPanel(); 
		
		// set layout for components
		GridBagConstraints labelLayout = new LabelLayout().setLabelLayout(); // done
		GridBagConstraints buttonLayout = new CreateRecordButtonLayout().setCreateRecordButtonLayout(); // done
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
		cancelButton.addActionListener(handler);
		buttonLayout.gridx = 0;
		formPanel.add(cancelButton, buttonLayout);
		
		// add 'submit' button to form
		submitButton = new SubmitButton().setSubmitButton();
		submitButton.addActionListener(handler);
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
	private class TheHandler implements ActionListener {
		
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
						
						System.out.println("batch:   " + batchIdController.getBatchIdList());
						System.out.println("machine: " + machineNumberController.getMachineNumberList());
						System.out.println("bubble:  " + bubbleCountController.getBubbleCountList());
						System.out.println("date:    " + dateTimeController.getDateTimeList());
						
						
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
				System.out.println("batch:   " + batchIdController.getBatchIdList());
				System.out.println("machine: " + machineNumberController.getMachineNumberList());
				System.out.println("bubble:  " + bubbleCountController.getBubbleCountList());
				System.out.println("date:    " + dateTimeController.getDateTimeList());
				if (machineOneActive == false) {
					machineOneButton.setBackground(Color.gray);
					machineOneActive = true;
					
					
				}	
				else if (machineOneActive == true) {
					machineOneButton.setBackground(new JButton().getBackground());
					machineOneActive = false;
				}
			}
			
			// handle 'machine 2' button click
			else if (e.getSource() == machineTwoButton)
			{
				if (machineTwoActive == false) {
					machineTwoButton.setBackground(Color.gray);
					machineTwoActive = true;
				}	
				else if (machineTwoActive == true) {
					machineTwoButton.setBackground(new JButton().getBackground());
					machineTwoActive = false;
				}
			}
			
			// handle 'machine 3' button click
			else if (e.getSource() == machineThreeButton)
			{
				if (machineThreeActive == false) {
					machineThreeButton.setBackground(Color.gray);
					machineThreeActive = true;
				}	
				else if (machineThreeActive == true) {
					machineThreeButton.setBackground(new JButton().getBackground());
					machineThreeActive = false;
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
	
