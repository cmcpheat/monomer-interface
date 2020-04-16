//package com.monomer.controllers;
//
//import java.util.ArrayList;
//
//public class BinarySearchController {
//	
//	// array to be searched
//	// array of indexes to match
//	// return array of Strings
//	
//	private ArrayList<String> result;
//	
//	public ArrayList<String> arrayBinarySearch( ArrayList<String> s, ArrayList<Integer> i ) {
//		
//		// loop through list of indexes in integer array
//		for (int x = 0; x < i.size(); x++) {
//			
//			int y = i.get(x);
//			// position y of string array
//			
//			// find value of index in string array
//			int first = 0;
//			int last = s.size() - 1;
//			
//			while (first <= last) {
//				
//				int mid = (first + last) / 2;
//				
//				int sm = Integer.parseInt(s.get(mid));
//				int sy = Integer.parseInt(s.get(y));
//				
//				if (sm == sy) {
//					result.add(s.get(mid));
//				}
//				
//				else if (sm < sy) {
//					first = mid + 1;					
//				}
//				
//				else if (sm > sy)
//				{
//					last = mid - 1;
//				}
//				
//				
//			}
//		}
//		return result;
//	}
//	
//	
//
//}
