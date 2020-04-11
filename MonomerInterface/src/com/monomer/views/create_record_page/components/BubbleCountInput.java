package com.monomer.views.create_record_page.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class BubbleCountInput extends JTextField {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField bubbleCountInput;
	boolean bubbleIsValidFormat;
	private BubbleCountAlertLabel bubbleCountAlertLabel = new BubbleCountAlertLabel();
	
	public JTextField setBubbleCountInput() {
		
		bubbleCountInput = new JTextField("");
		// validates number between 0-600 and sets boolean to true/false
//		bubbleCountInput.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				String str = bubbleCountInput.getText();
//				 try 
//				 { 
//		            Integer.parseInt(str);
//		            int i = Integer.parseInt(str);
//		            if (i < 0 || i > 600) {
//		            	bubbleIsValidFormat = false;
//					}
//		            else {
//		            	bubbleIsValidFormat = true;
//		            	bubbleCountAlertLabel.clearField();
//		            }
//		        }  
//		        catch (NumberFormatException e1)  
//		        { 
//		        	bubbleIsValidFormat = false;
//		        } 
//			}
//		});
		bubbleCountInput.setBorder(BorderFactory.createCompoundBorder(
		bubbleCountInput.getBorder(), 
        BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		bubbleCountInput.setFont (bubbleCountInput.getFont ().deriveFont (12.0f));
		
		return bubbleCountInput;
	}
}
