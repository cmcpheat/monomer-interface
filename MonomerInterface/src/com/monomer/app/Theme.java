package com.monomer.app;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Theme { 
	
	private static String theme = "Nimbus";
	
	// sets GUI theme to 'nimbus'
	public void setTheme() {
		try { 
	    	for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	    		if (theme.equals(info.getName())) {
	    			UIManager.setLookAndFeel(info.getClassName());
	    			System.out.println("Nimbus theme set successfully."); 
	    			break;
	    		}
	    	}
	    }

	    catch (Exception e) { 
	        System.out.println("There has been an error setting Nimbus theme. Default theme set."); 
	    }
	}
}
	


