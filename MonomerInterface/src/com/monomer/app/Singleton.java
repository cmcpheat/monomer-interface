package com.monomer.app;

// TODO Singleton not finished and not in use. 

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.monomer.controllers.CreateRecordViewController;
import com.monomer.controllers.LiveDataViewController;

public class Singleton {

   private static Singleton singleton = new Singleton( );
   private JFrame frame = new JFrame();

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   private Singleton() { }

   /* Static 'instance' method */
   public static Singleton getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
   protected JFrame guiConstructor( ) {
	   
		// frame setup
		frame = new JFrame();
		frame.setResizable(false); // prevents resizing
		Dimension frameSize = new Dimension(1000, 700);
		frame.setPreferredSize(frameSize);
//		ImageIcon icon = new ImageIcon("/icon2.png");
//		frame.setIconImage(icon.getImage());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // allows processes to end before quitting 
		frame.setTitle("Monomer Data");
		
		// create tabs
		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(0,0,0,0);
		
		// create pages
		JPanel liveDataPage = new LiveDataViewController().addLiveDataPage();
		JPanel createRecordPage = new CreateRecordViewController().addCreateRecordPage();
		
		// add pages to tabs
		tabs.add("Live Data", liveDataPage);
		tabs.add("Create a Record", createRecordPage);
		frame.add(tabs);
		
		// show GUI
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); // centres the window	
		
		return frame;
	      
   }
}