package com.monomer.models;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class MachineNumberModel {
	
	ArrayList<String> MACHINE_NUM_LIST = new ArrayList<String>();
	
	public MachineNumberModel () {
		
	}
	
	public void setMachineNumber(String mn) throws IOException
	{		
		MACHINE_NUM_LIST.add(mn);
		save(mn);
	}
	
	public String getMachineNumber(int index) {
		return MACHINE_NUM_LIST.get(index);
	}
	
	public void printAllMachineNumbers() {
		System.out.println("MN List: " + MACHINE_NUM_LIST);
	}
	
	public void save(String s) throws IOException  {
		Writer wr = new FileWriter("/C:/Users/chris/Desktop/Test/machine_numbers.txt", true);
		wr.write(s);
		wr.write("\n");
		wr.close();
	}
	
	public ArrayList<String> read() {
	
		try (FileReader f = new FileReader("/C:/Users/chris/Desktop/Test/machine_numbers.txt"))
		{
			StringBuffer sb = new StringBuffer();
			while (f.ready()) {
				char c = (char) f.read();
				if (c == '\n') {
					MACHINE_NUM_LIST.add(sb.toString());
					sb = new StringBuffer();
				}
				else {
					sb.append(c);
				}
			}
			if (sb.length() > 0) {
				MACHINE_NUM_LIST.add(sb.toString());
			}
		}
		catch (IOException exc) {
			System.out.println("FILE NOT FOUND");
		}
		System.out.println("machines: " + MACHINE_NUM_LIST);
		
		return MACHINE_NUM_LIST;
	}
}