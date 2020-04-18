package com.monomer.app;

import javax.swing.SwingUtilities;

import com.monomer.controllers.GuiController;

public class Singleton {
	
	private static Singleton instance;

    /**
     * A private Constructor prevents any other class from
     * instantiating.
     */
    private Singleton() {
        // nothing to do this time
    }

    static {
        instance = new Singleton();
    }

    /** Static 'instance' method */
    public static Singleton getInstance() {
        return instance;
    }

    // other methods protected by singleton-ness would be here...
    /** A simple demo method */
    public void run() {
    	
    	// GUI runs on its own thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GuiController();
			}
		});
    }
}
