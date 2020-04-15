//package com.monomer.controllers;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Writer;
//import java.util.List;
//
//import com.monomer.models.BatchIdModel;
//
//public class BatchIdListController {
//	
//	private BatchIdModel batchIdModel;
//	
//	public BatchIdListController() {
//		
//		batchIdModel = new BatchIdModel();
//		
//		
//	}
//	
//	public void readListFromFile() {
//		
//			try (FileReader f = new FileReader("./res/batch_ids.txt"))
//			{
//				StringBuffer sb = new StringBuffer();
//				while (f.ready()) {
//					char c = (char) f.read();
//					if (c == '\n') {
//						batchIdModel.setBatchId(sb.toString());
//						sb = new StringBuffer();
//					}
//					else {
//						sb.append(c);
//					}
//				}
//				if (sb.length() > 0) {
//					batchIdModel.setBatchId(sb.toString());
//				}
//			}
//			catch (IOException exc) {
//				System.out.println("Batch ID database error. File not found.");
//			}
//			System.out.println("read batches from file:  " + batchIdModel.getList() + "\n");
//					
//	}
//	
//	public void saveListToFile() throws IOException {
//		
//		BatchIdModel batchIdModel = new BatchIdModel();
//		List<String> list = batchIdModel.getList();
//		
//		System.out.println("list to save: " + list);
//		
//		for (int i = 0; i < list.size(); i++) {
//			Writer wr;
//		
//			wr = new FileWriter("./res/batch_ids.txt", true);
//			
//			wr.write(list.get(i));
//			wr.write("\n");
//			wr.close();
//		}
//					
//	}
//}
//
//
