package com.monomer.models;

import java.util.ArrayList;

public class MachineNumberModel {
	
	ArrayList<Integer> MACHINE_NUM_LIST = new ArrayList<Integer>();
	
	public MachineNumberModel () {
		
	}
	
	public void setMachineNumber(int mn)
	{		
		MACHINE_NUM_LIST.add(mn);
	}
	
	public int getMachineNumber(int index) {
		return MACHINE_NUM_LIST.get(index);
	}
	
	public void printAllMachineNumbers() {
		System.out.println("MN List: " + MACHINE_NUM_LIST);
	}

}