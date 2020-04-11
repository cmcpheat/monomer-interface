package com.monomer.models;

import java.util.ArrayList;

//class which stores and retrieves the batch IDs
public class BatchIdArray {
	
	private static ArrayList<Integer> batchIds = new ArrayList<Integer>();
	private static int batchId;
	
	public static void setBatchId(int batch) {
		batchIds.add(batch);
	}
	
	public static int getBatchId(int index) {
		batchId = batchIds.get(index);
		return batchId;
	}

}
