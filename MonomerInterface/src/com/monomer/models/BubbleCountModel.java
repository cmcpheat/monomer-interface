package com.monomer.models;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class BubbleCountModel {
	
	ArrayList<String> BUBBLE_COUNT_LIST = new ArrayList<String>();
	
	public BubbleCountModel() {
		
	}
	
	public void setBubbleCount(String bc) throws IOException
	{		
		BUBBLE_COUNT_LIST.add(bc);
		save(bc);
	}
	
	public String getBubbleCount(int index) {
		return BUBBLE_COUNT_LIST.get(index);
	}
	
	public void printAllBubbleCounts() {
		System.out.println("BC List: " + BUBBLE_COUNT_LIST);
	}

	public void save(String s) throws IOException  {
		Writer wr = new FileWriter("/C:/Users/chris/Desktop/Test/bubble_counts.txt", true);
		wr.write(s);
		wr.write("\n");
		wr.close();
	}
	
	public ArrayList<String> read() {
	
		try (FileReader f = new FileReader("/C:/Users/chris/Desktop/Test/bubble_counts.txt"))
		{
			StringBuffer sb = new StringBuffer();
			while (f.ready()) {
				char c = (char) f.read();
				if (c == '\n') {
					BUBBLE_COUNT_LIST.add(sb.toString());
					sb = new StringBuffer();
				}
				else {
					sb.append(c);
				}
			}
			if (sb.length() > 0) {
				BUBBLE_COUNT_LIST.add(sb.toString());
			}
		}
		catch (IOException exc) {
			System.out.println("FILE NOT FOUND");
		}
		System.out.println("bubbles:  " + BUBBLE_COUNT_LIST);
		
		return BUBBLE_COUNT_LIST;
	}
	
}
