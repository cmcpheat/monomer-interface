package com.monomer.data;

import java.util.ArrayList;

//class which stores and retrieves the bubble counts
public class BubbleCountArray {

	private static ArrayList<Integer> bubbleCounts = new ArrayList<Integer>();
	private static int bubbleCount;
	
	public static void setBatchId(int bubble) {
		bubbleCounts.add(bubble);
	}
	
	public static int getBatchId(int index) {
		bubbleCount = bubbleCounts.get(index);
		return bubbleCount;
	}
	
}
