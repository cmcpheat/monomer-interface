package com.monomer.models;

import java.util.ArrayList;

public class MachineNumberModel {
	
	private ArrayList<String> list = new ArrayList<>();
		
	public ArrayList<String> getMachineNumberList() {
		return list;
	}
	
	public String getMachineNumAtIndex(int index) {
		String machineNum = list.get(index);
		return machineNum;
	}

}
