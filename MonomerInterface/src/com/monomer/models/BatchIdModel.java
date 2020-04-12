package com.monomer.models;

import java.util.ArrayList;
import java.util.List;

public class BatchIdModel {

   public List<Integer> batchIds = new ArrayList<>();

   public void addBatchId( int batchId ) {
      batchIds.add( batchId );
      // System.out.println("batches: " + batchIds.toString());
   }
   
   public List<Integer> getList() {
	   return batchIds;
   }
} 