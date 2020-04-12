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
		final BatchIdModel batchIdList = new BatchIdModel();
		batchIdList.addBatchId(bi);
		System.out.println("batches: " + batchIdList.batchIds.toString());
	}
	
	public void processMachineNumber(int mn) {
		final MachineNumberModel machineNumList = new MachineNumberModel();
		machineNumList.addMachineNumber(mn);
		System.out.println("machines: " + machineNumList.machines.toString());
	}
	
	public void processBubbleCount(int bc) {
		final BubbleCountModel bubbleCountList = new BubbleCountModel();
		bubbleCountList.addBubbleCount(bc);
		System.out.println("bubbles: " + bubbleCountList.bubbles.toString());
	}
	
	public void processDateTime(String dt) {
		final DateTimeModel dateTimeList = new DateTimeModel();
		dateTimeList.addDateTime(dt);
		System.out.println("dates: " + dateTimeList.dates.toString());
	}

}
