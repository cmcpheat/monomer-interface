package com.monomer.models;

import java.util.ArrayList;
import java.util.List;

public class BatchIdModel {

   public final List<Integer> batchIds = new ArrayList<>();

   public void addBatchId( int batchId ) {
      batchIds.add( batchId );
   }
} 