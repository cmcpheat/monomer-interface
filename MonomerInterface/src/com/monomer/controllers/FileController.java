package com.monomer.controllers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class FileController {
	
	// class for saving data to file so it can be loaded upon reopening the application
		
	public void saveToFile(ArrayList<String> list, String type) {
		
		// TODO omit batch IDs that are already saved? 
		
		try {
			for (int i = 0; i < list.size(); i++) {
				
				Writer wr = new FileWriter("./res/" + type + ".txt", true);
				wr.write(list.get(i));
				wr.write("\n");
				wr.close();				
			}
		}
		catch (IOException exc) {
			System.out.println("Error saving to file.");
			exc.printStackTrace();
		}
	}
	
	// read data from files and save in arrays
	public ArrayList<String> readFromFile(String type) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		try (FileReader f = new FileReader("./res/" + type + ".txt"))
		{
			
			StringBuffer sb = new StringBuffer();
			while (f.ready()) {
				char c = (char) f.read();
				if (c == '\n') {
					list.add(sb.toString());
					sb = new StringBuffer();
				}
				else {
					sb.append(c);
				}
			}
			if (sb.length() > 0) {
				list.add(sb.toString());
			}
		}
		catch (IOException exc) {
			System.out.println("Datastore error. File '" + type + ".txt' not found.");
		}

		return list;
	}
}
