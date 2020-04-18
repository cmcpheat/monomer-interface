package com.monomer.models;

import java.util.ArrayList;

public class BubbleCountModel {
	
	private ArrayList<String> list = new ArrayList<>();
		
	public ArrayList<String> getBubbleCountList() {
		return list;
	}
	
	public String getBubbleCountAtIndex(int index) {
		String bubbleCount = list.get(index);
		return bubbleCount;
	}

}
