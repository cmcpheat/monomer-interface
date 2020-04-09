package com.monomer.data;

import java.util.ArrayList;

//class which stores and retrieves the machine numbers
public class MachineNumberArray {
	
	private static ArrayList<Integer> machineNumbers = new ArrayList<Integer>();
	private static int machineNumber;
	
	public static void setMachineNumber(int machine) {
		machineNumbers.add(machine);
	}
	
	public static int getMachineNumber(int index) {
		machineNumber = machineNumbers.get(index);
		return machineNumber;
	}

}
