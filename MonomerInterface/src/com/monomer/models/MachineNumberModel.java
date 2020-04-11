package com.monomer.models;

import java.util.ArrayList;
import java.util.List;

public class MachineNumberModel {
	
	public final List<Integer> machines = new ArrayList<>();
	
	public void addMachineNumber (int machineNumber ) {
		machines.add( machineNumber );
	}
}
