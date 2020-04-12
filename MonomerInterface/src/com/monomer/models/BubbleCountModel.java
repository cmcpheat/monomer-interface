package com.monomer.models;

import java.util.ArrayList;

public class BubbleCountModel {
	
	ArrayList<Integer> BUBBLE_COUNT_LIST = new ArrayList<Integer>();
	
	public BubbleCountModel() {
		
	}
	
	public void setBubbleCount(int bc)
	{		
		BUBBLE_COUNT_LIST.add(bc);
	}
	
	public int getBubbleCount(int index) {
		return BUBBLE_COUNT_LIST.get(index);
	}
	
	public void printAllBubbleCounts() {
		System.out.println("BC List: " + BUBBLE_COUNT_LIST);
	}

}
