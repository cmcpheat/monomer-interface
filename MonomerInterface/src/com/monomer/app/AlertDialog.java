package com.monomer.app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AlertDialog {
	
	// Alert dialog that shows when an instance of app is already running
    private static JDialog d;  
    public AlertDialog() {  
        JFrame f= new JFrame();  
        
        f.setLocationRelativeTo(null); // centres the alert
        d = new JDialog(f , "Warning", true);  
        d.setLayout( new BorderLayout() );  
        d.setBounds(1000, 0, 0, 0);
        JButton b = new JButton ("Cancel");  
        b.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
                AlertDialog.d.setVisible(false);  
            }
        });  
        d.add( new JLabel ("Application is already running."));  
        d.add(b, BorderLayout.PAGE_END);
        d.setSize(200,150);
        d.setResizable(false);
        d.setLocationRelativeTo(null);
        d.setVisible(true);     
    }  
}