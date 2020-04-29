package com.monomer.app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AlertDialog {
	
	private static JDialog dialog;
	private JFrame frame;
	
	// Alert dialog that shows when an instance of app is already running

    public AlertDialog() {  
        
    	frame= new JFrame();     
        frame.setLocationRelativeTo(null); // centres the alert
        dialog = new JDialog(frame , "Warning", true);  
        dialog.setLayout( new BorderLayout() );  
        dialog.setBounds(1000, 0, 0, 0);
        JButton b = new JButton ("Cancel");  
        b.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
                AlertDialog.dialog.setVisible(false);  
            }
        });  
        dialog.add( new JLabel ("Application is already running."));  
        dialog.add(b, BorderLayout.PAGE_END);
        dialog.setSize(200,150);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);     
    }  
}