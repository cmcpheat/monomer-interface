package com.monomer.models;

import java.util.ArrayList;

public class BatchIdModel {
	
	private ArrayList<String> list;
	
	public BatchIdModel() {
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
