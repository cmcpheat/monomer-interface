package com.monomer.controllers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class FileController {
	
	// class for saving data to file so it can be loaded upon reopening the application
	
	private ArrayList<String> batchListToSave;
	private ArrayList<String> bubbleListToSave;
	private ArrayList<String> machineListToSave;
	private ArrayList<String> dateListToSave;
	
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
		
		try (FileReader f = new FileReader("./res/batch_ids.txt"))
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
