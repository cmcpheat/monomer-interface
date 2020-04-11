package com.monomer.models;

import java.util.ArrayList;
import java.util.List;

public class BubbleCountModel {
	
	public final List<Integer> bubbles = new ArrayList<>();
	
	public void addBubbleCount( int bubbleCount ) {
		bubbles.add( bubbleCount );
	}
}
