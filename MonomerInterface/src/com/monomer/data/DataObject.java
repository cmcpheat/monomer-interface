package com.monomer.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataObject {
	
	private int batchId;
	private int machineNumber;
	private int bubbleCount;
	private String dateTime;
	private String currentDateTime;
	
	public DataObject() {
		
	}
	
	public void setBatchId(String bId) {
		this.batchId = Integer.parseInt(bId);
	}
	
	public void setMachineNumber(String mNum) {
		this.machineNumber = Integer.parseInt(mNum);
	}
	
	public void setBubbleCount(String bCount) {
		this.bubbleCount = Integer.parseInt(bCount);
	}
	
	public void setDateTime(String dateTimeStamp) {
		this.dateTime = dateTimeStamp;
	} 
	
	public int getBatchId() {
		return this.batchId;
	}
	
	public int getMachineNumber() {
		return this.machineNumber;
	}
	
	public int getBubbleCount() {
		return this.bubbleCount;
	}
	
	public String getDateTime() {
		return this.dateTime;
	}
	
	public String getCurrentDateTimeStamp() {
		final LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return this.currentDateTime = currentDateTime.format(formatter);
	}
}	
	

