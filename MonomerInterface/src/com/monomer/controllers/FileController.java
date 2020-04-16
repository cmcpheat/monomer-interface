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
	
	public void readFromFile() {
		
		String[] types = new String[4];
		types[0] = "batch_ids";
		types[1] = "machine_numbers";
		types[2] = "bubble_counts";
		types[3] = "machine_numbers";
		
		for (int i = 0; i < types.length; i++) {
			
			try (FileReader f = new FileReader("./res/" + types[i] + ".txt"))
			{
				StringBuffer sb = new StringBuffer();
				while (f.ready()) {
					char c = (char) f.read();
					if (c == '\n') {
						BATCH_ID_LIST.add(sb.toString());
						sb = new StringBuffer();
					}
					else {
						sb.append(c);
					}
				}
				if (sb.length() > 0) {
					BATCH_ID_LIST.add(sb.toString());
				}
			}
			catch (IOException exc) {
				System.out.println("Batch ID database error. File not found.");
			}
			
		}
		
			
	}

}
