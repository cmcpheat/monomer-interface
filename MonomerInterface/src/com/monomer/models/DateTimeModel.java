package com.monomer.models;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DateTimeModel {
	
	ArrayList<String> DATE_TIME_LIST = new ArrayList<String>();
	ArrayList<Integer> SEARCH_RESULT = new ArrayList<Integer>();
	ArrayList<Integer> LIST_OF_INDEXES = new ArrayList<Integer>();
	
	
	public DateTimeModel () {
		
	}
	
	public void setDateTime(String dt) throws IOException
	{		
		DATE_TIME_LIST.add(dt);
		save(dt);
	}
	
	// takes in index number at returns date/time string at that position
	public String getDateTime(int index) {
		return DATE_TIME_LIST.get(index);
	}
	
	public ArrayList<Integer> searchForDateRange(LocalDateTime current, LocalDateTime range) {
		
		// takes in date selection
		// searches through the DATE_TIME_LIST for date selection
		// returns the list of array index numbers that are in that range
		
		
		
		
		return LIST_OF_INDEXES;
	}
	
	public void printAllDateTimes() {
		System.out.println("DT List: " + DATE_TIME_LIST);
	}
	
	public void save(String s) throws IOException  {
		Writer wr = new FileWriter("/C:/Users/chris/Desktop/Test/date_times.txt", true);
		wr.write(s);
		wr.write("\n");
		wr.close();
	}
	
	public ArrayList<String> read() {
	
		try (FileReader f = new FileReader("/C:/Users/chris/Desktop/Test/date_times.txt"))
		{
			StringBuffer sb = new StringBuffer();
			while (f.ready()) {
				char c = (char) f.read();
				if (c == '\n') {
					DATE_TIME_LIST.add(sb.toString());
					sb = new StringBuffer();
				}
				else {
					sb.append(c);
				}
			}
			if (sb.length() > 0) {
				DATE_TIME_LIST.add(sb.toString());
			}
		}
		catch (IOException exc) {
			System.out.println("FILE NOT FOUND");
		}
		System.out.println("dates:    " + DATE_TIME_LIST);
		
		return DATE_TIME_LIST;
	}	
}