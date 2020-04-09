package com.monomer.data;

import com.monomer.json.JSONObject;

public class DataObject extends JSONObject {
	
//	private int batchId;
//	private int machineNumber;
//	private int bubbleCount;
	
	private JSONObject data;
	
	public DataObject() {
		
		data = new JSONObject();
	}
	
	public JSONObject createDataObject(int bi, int mn, int bc, String dt) {
		
		data.put("batch_id", bi);
		data.put("machine_number", mn);
		data.put("bubble_count", bc);
		data.put("date_time", dt);
		
		return data;	
	}
}	
	

