package com.monomer.gui;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Theme { 
	
	private static String theme = "Nimbus";
	
	// Sets theme to Nimbus
	public static void setTheme() {
		try { 
	    	for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	    		if (theme.equals(info.getName())) {
	    			UIManager.setLookAndFeel(info.getClassName());
	    			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    			 break;
	    		}
	    	}
	    }

	    catch (Exception e) { 
	        System.out.println("Look and Feel not set"); 
	    }
	}
}
	


