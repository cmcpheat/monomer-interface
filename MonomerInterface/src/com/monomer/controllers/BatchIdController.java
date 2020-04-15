package com.monomer.controllers;

import java.util.ArrayList;

public class BatchIdController {
	
	private ArrayList<String> list;
	
	public BatchIdController() {
		list = new ArrayList<>();
	}
	
	public ArrayList<String> getBatchIdList() {
		return list;
	}
	
	public String getBatchIdAtIndex(int index) {
		String batchId = list.get(index);
		return batchId;
	}

}
