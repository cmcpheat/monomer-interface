package com.monomer.models;

import java.util.ArrayList;

public class BatchIdModel {
	
	ArrayList<Integer> BATCH_ID_LIST = new ArrayList<Integer>();
	
	public BatchIdModel () {
		
	}
	
	public void setBatchId(int bi)
	{		
		BATCH_ID_LIST.add(bi);
	}
	
	public int getBatchId(int index) {
		return BATCH_ID_LIST.get(index);
	}

	public void printAllBatchIds() {
		System.out.println("BI List: " + BATCH_ID_LIST);
	}
}
