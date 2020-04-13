package com.monomer.models;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;



public class BatchIdModel {
	
	int z= 1;
	
	ArrayList<String> BATCH_ID_LIST = new ArrayList<String>();
	
	public BatchIdModel () {
		
	}
	
	public void setBatchId(String bi) throws IOException 
	{		
		BATCH_ID_LIST.add(bi);
		save(bi);
	}
	
	public String getBatchId(int index) {
		return BATCH_ID_LIST.get(index);
	}

	public void printAllBatchIds() {
		System.out.println("BI List: " + BATCH_ID_LIST);
	}
	
	public void save(String s) throws IOException  {
		Writer wr = new FileWriter("/C:/Users/chris/Desktop/Test/batch_ids.txt", true);
		wr.write(s);
		wr.write("\n");
		wr.close();
	}
	
	public ArrayList<String> read() {
	
		try (FileReader f = new FileReader("/C:/Users/chris/Desktop/Test/batch_ids.txt"))
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
			System.out.println("FILE NOT FOUND");
		}
		System.out.println("batches:  " + BATCH_ID_LIST);
		
		return BATCH_ID_LIST;
	}
}
