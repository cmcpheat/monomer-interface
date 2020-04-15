package com.monomer.controllers;

import java.util.ArrayList;

public class MachineNumberController {
	
	private ArrayList<String> list = new ArrayList<>();
		
	public ArrayList<String> getMachineNumberList() {
		return list;
	}
	
	public String getMachineNumAtIndex(int index) {
		String machineNum = list.get(index);
		return machineNum;
	}

}
