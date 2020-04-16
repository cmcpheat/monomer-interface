package com.monomer.controllers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class FileController {
	
	// class for saving data to file so it can be loaded upon reopening the application
	
	private ArrayList<String> batchListToRead;
	private ArrayList<String> bubbleListToRead;
	private ArrayList<String> machineListToRead;
	private ArrayList<String> dateListToRead;
	
	private BatchIdController batchIdController = new BatchIdController();
	private MachineNumberController machineNumberController = new MachineNumberController();
	private BubbleCountController bubbleCountController = new BubbleCountController();
	private DateTimeController dateTimeController = new DateTimeController();
		
	public void saveToFile(ArrayList<String> list, String type) {
		
		try {
			for (int i = 0; i < list.size(); i++) {
				
				Writer wr = new FileWriter("./res/" + type + ".txt", true);
				wr.write(list.get(i));
				wr.write("\n");
				wr.close();				
			}
		}
		catch (IOException exc) {
			System.out.println("Error occurred");
			exc.printStackTrace();
		}
	}
	
	public void readBatchesFromFile() {
		
		try (FileReader f = new FileReader("./res/batch_ids.txt"))
		{
			
			StringBuffer sb = new StringBuffer();
			while (f.ready()) {
				char c = (char) f.read();
				if (c == '\n') {
					batchIdController.getBatchIdList().add(sb.toString());
					System.out.println(sb);
					sb = new StringBuffer();
				}
				else {
					sb.append(c);
				}
			}
			if (sb.length() > 0) {
				batchIdController.getBatchIdList().add(sb.toString());
			}
		}
		catch (IOException exc) {
			System.out.println("Batch ID datastore error. File not found.");
		}	
	}
	
	public void readMachinesFromFile() {
		
		try (FileReader f = new FileReader("./res/machine_numbers.txt"))
		{
			
			StringBuffer sb = new StringBuffer();
			while (f.ready()) {
				char c = (char) f.read();
				if (c == '\n') {
					machineNumberController.getMachineNumberList().add(sb.toString());
					System.out.println(machineNumberController);
					sb = new StringBuffer();
				}
				else {
					sb.append(c);
				}
			}
			if (sb.length() > 0) {
				machineNumberController.getMachineNumberList().add(sb.toString());
			}
		}
		catch (IOException exc) {
			System.out.println("Machine number datastore error. File not found.");
		}	
	}
	
	public void readBubblesFromFile() {
		
		try (FileReader f = new FileReader("./res/bubble_counts.txt"))
		{
			
			StringBuffer sb = new StringBuffer();
			while (f.ready()) {
				char c = (char) f.read();
				if (c == '\n') {
					bubbleCountController.getBubbleCountList().add(sb.toString());
					sb = new StringBuffer();
				}
				else {
					sb.append(c);
				}
			}
			if (sb.length() > 0) {
				bubbleCountController.getBubbleCountList().add(sb.toString());
			}
		}
		catch (IOException exc) {
			System.out.println("Bubble count datastore error. File not found.");
		}	
	}
	
	public void readDatesFromFile() {
		
		try (FileReader f = new FileReader("./res/date_times.txt"))
		{
			
			StringBuffer sb = new StringBuffer();
			while (f.ready()) {
				char c = (char) f.read();
				if (c == '\n') {
					dateTimeController.getDateTimeList().add(sb.toString());
					sb = new StringBuffer();
				}
				else {
					sb.append(c);
				}
			}
			if (sb.length() > 0) {
				dateTimeController.getDateTimeList().add(sb.toString());
			}
		}
		catch (IOException exc) {
			System.out.println("Date/time datastore error. File not found.");
		}	
	}

}
