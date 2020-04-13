package com.monomer.models;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class BatchIdModel {
	
	ArrayList<String> BATCH_ID_LIST = new ArrayList<String>();
	
	public BatchIdModel () {
		
	}
	
	
	// TODO - change this to read all from file and add, same as read()
	public void setBatchId(String bi) throws IOException 
	{	
		read();
		BATCH_ID_LIST.add(bi);
		save(bi);
		System.out.println("the whole list: " + BATCH_ID_LIST);
	}
	
	public String getBatchId(int index) {
		return BATCH_ID_LIST.get(index);
	}

	public void printAllBatchIds() {
		System.out.println("BI List: " + BATCH_ID_LIST);
		for (int i = 0; i < BATCH_ID_LIST.size(); i++) {
			System.out.println("Index " + i + ": " + BATCH_ID_LIST.get(i));
		}
	}
	
	public ArrayList<String> getWholeList() {
		System.out.println(BATCH_ID_LIST.size());
		return BATCH_ID_LIST;
		
	}
	
	public void save(String s) throws IOException  {
		try {
			Writer wr = new FileWriter("./res/batch_ids.txt", true);
			wr.write(s);
			wr.write("\n");
			wr.close();
		}
		catch (IOException exc) {
			System.out.println("Error occurred here");
		}
	}
	
	// TODO should return or not?
	public void read() {
	
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
			System.out.println("Error. File not found.");
		}
		System.out.println("batches:  " + BATCH_ID_LIST);
		
	}
}
