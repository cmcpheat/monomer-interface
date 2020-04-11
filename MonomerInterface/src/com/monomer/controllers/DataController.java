package com.monomer.controllers;

import com.monomer.json.JSONObject;
import com.monomer.models.BatchIdModel;
import com.monomer.models.BubbleCountModel;
import com.monomer.models.DateTimeModel;
import com.monomer.models.MachineNumberModel;

public class DataController {
		
	public void sendJSONData(JSONObject json) {
		processBatchId(json.getInt("batch_id"));
		processMachineNumber(json.getInt("machine_number"));
		processBubbleCount(json.getInt("bubble_count"));
		processDateTime(json.getString("date"));
	}

	public void processBatchId(int bi) {
		final BatchIdModel batches = new BatchIdModel();
		batches.addBatchId(bi);
	}
	
	public void processMachineNumber(int mn) {
		final MachineNumberModel machines = new MachineNumberModel();
		machines.addMachineNumber(mn);
	}
	
	public void processBubbleCount(int bc) {
		final BubbleCountModel bubbles = new BubbleCountModel();
		bubbles.addBubbleCount(bc);
	}
	
	public void processDateTime(String dt) {
		final DateTimeModel dates = new DateTimeModel();
		dates.addDateTime(dt);
	}

}
