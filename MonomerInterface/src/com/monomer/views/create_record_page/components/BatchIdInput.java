package com.monomer.views.create_record_page.components;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class BatchIdInput {
	
	JTextField batchIdInput;
	boolean batchIsValidFormat;
	
	public JTextField setBatchIdInput() {
		
		batchIdInput = new JTextField("", 20);
		// validates number between 000001 - 999999 and sets boolean to true/false
		batchIdInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String str = batchIdInput.getText();
				 try 
				 { 
		            Integer.parseInt(str);
		            int ii = Integer.parseInt(str);
		            if (ii < 1 || ii > 999999) {
		            	batchIsValidFormat = false;
					}
		            else {
		            	batchIsValidFormat = true;
		            	// batchIdValidationLabel.setText(" ");
		            }
		        }  
		        catch (NumberFormatException e1)  
		        { 
		        	batchIsValidFormat = false;
		        } 
			}
		});
		batchIdInput.setBorder(BorderFactory.createCompoundBorder(
		batchIdInput.getBorder(), 
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		batchIdInput.setFont (batchIdInput.getFont ().deriveFont (12.0f));
	
		return batchIdInput;
	}
}
