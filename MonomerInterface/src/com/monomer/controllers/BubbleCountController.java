package com.monomer.controllers;

import java.util.ArrayList;

public class BubbleCountController {
	
	private ArrayList<String> list = new ArrayList<>();
		
	public ArrayList<String> getBubbleCountList() {
		return list;
	}
	
	public String getBubbleCountAtIndex(int index) {
		String bubbleCount = list.get(index);
		return bubbleCount;
	}

}
