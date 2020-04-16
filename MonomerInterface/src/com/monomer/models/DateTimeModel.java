//package com.monomer.models;
//
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Writer;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DateTimeModel {
//	
//	ArrayList<String> DATE_TIME_LIST = new ArrayList<String>();
//	static ArrayList<Integer> LIST_OF_INDEXES = new ArrayList<Integer>();
//	// ArrayList<String> DATE_TIME_STRINGS = new ArrayList<String>();
//	
//	
//	public DateTimeModel () {
//		
//	}
//	
//	public void setDateTime(String dt) throws IOException
//	{		
//		DATE_TIME_LIST.add(dt);
//		save(dt);
//	}
//	
//	// takes in index number at returns date/time string at that position
//	public String getDateTime(int index) {
//		return DATE_TIME_LIST.get(index);
//	}
//	
//	public List<String> getList() {
//		return DATE_TIME_LIST;
//	}
//	
//	public static ArrayList<Integer> searchForDateRange(ArrayList<LocalDateTime> list, LocalDateTime now, LocalDateTime then) {
//		
//		// takes in date selection
//		// searches through the DATE_TIME_LIST for date selection
//		// returns the list of array index numbers that are in that range
//	  
//		int index = 0;
//		int max = list.size();
//
//		while (index < max) {
//			
//			if (list.get(index).isBefore(now) && list.get(index).isAfter(then)) {
//				// System.out.println("DATE: " + list.get(index) + " is in range");
//				LIST_OF_INDEXES.add(index);
//			}
//			else if (list.get(index).isBefore(then)) {
//				// System.out.println("DATE: " + list.get(index) + " is out of range");
//			}
//			index++;
//		}
//		return LIST_OF_INDEXES;
//	}
//	
//	public void printAllDateTimes() {
//		System.out.println("DT List: " + DATE_TIME_LIST);
//	}
//	
//	// save data to text file 
//	public void save(String dt) throws IOException  {
//		
//		Writer wr = new FileWriter("./res/date_times.txt", true);
//		wr.write(dt);
//		wr.write("\n");
//		wr.close();
//	}
//	
//	// read data from file into array list
//	public ArrayList<String> read() {
//	
//		try (FileReader f = new FileReader("./res/date_times.txt"))
//		{
//			StringBuffer sb = new StringBuffer();
//			while (f.ready()) {
//				char c = (char) f.read();
//				if (c == '\n') {
//					DATE_TIME_LIST.add(sb.toString());
//					sb = new StringBuffer();
//				}
//				else {
//					sb.append(c);
//				}
//			}
//			if (sb.length() > 0) {
//				DATE_TIME_LIST.add(sb.toString());
//			}
//		}
//		catch (IOException exc) {
//			System.out.println("Date/time database error. File not found.");
//		}
//		System.out.println("dates:    " + DATE_TIME_LIST);
//		
//		return DATE_TIME_LIST;
//	}	
//}