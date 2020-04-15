package com.monomer.models;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class BatchIdModel {
	
	private List<String> BATCH_ID_LIST;
	
	
	public BatchIdModel () {
		BATCH_ID_LIST = new ArrayList<String>();
	}
	
	
	// TODO - change this to read all from file and add, same as read()
	public void setBatchId(String bi) throws IOException
	{	
		BATCH_ID_LIST.add(bi);
		save(bi);
		// System.out.println("batches2:  " + BATCH_ID_LIST);
		System.out.println("the new list: " + BATCH_ID_LIST);
	}
	
	public String getBatchId(int index) {
		return BATCH_ID_LIST.get(index);
	}

	public void printAllBatchIds() {
		// System.out.println("BI List: " + BATCH_ID_LIST);
		
	}
	
	public List<String> getList() {
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
//	
//	// TODO should return or not?
//	public List<String> read() {
//	
//		try (FileReader f = new FileReader("./res/batch_ids.txt"))
//		{
//			StringBuffer sb = new StringBuffer();
//			while (f.ready()) {
//				char c = (char) f.read();
//				if (c == '\n') {
//					BATCH_ID_LIST.add(sb.toString());
//					sb = new StringBuffer();
//				}
//				else {
//					sb.append(c);
//				}
//			}
//			if (sb.length() > 0) {
//				BATCH_ID_LIST.add(sb.toString());
//			}
//		}
//		catch (IOException exc) {
//			System.out.println("Batch ID database error. File not found.");
//		}
//		System.out.println("batches:  " + BATCH_ID_LIST);
//		
//		return BATCH_ID_LIST;
//		
//	}
}
