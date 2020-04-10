package com.monomer.app;

import com.monomer.data.DataObject;
import com.monomer.gui.pages.create_record.CreateRecordPage;
import com.monomer.gui.pages.live_data.LiveDataPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class GUI {
	
	private JFrame frame;
	private JPanel chartPanel;
	private JButton machineOneBtn;
	private JButton machineTwoBtn;
	private JButton machineThreeBtn;
	private JPanel formPanel;
	private JButton submitBtn;
	private JButton clearBtn;
	private JLabel batchLabel;
	private JLabel batchValidationLabel;
	private JLabel machineLabel;
	private JLabel machineValidationLabel;
	private JLabel bubbleLabel;
	private JLabel bubbleValidationLabel;
	private JLabel submitMessageLabel;
	private JTextField batchText;
	private JComboBox machineText;
	private JTextField bubbleText;
	private boolean machineOneActive = false;
	private boolean machineTwoActive = false;
	private boolean machineThreeActive = false;
	private boolean batchIsValidFormat = false;
	private boolean bubbleIsValidFormat = false;
	private int batchId;
	private int machineNumber;
	private int bubbleCount;
	private String dateTime;

	// GUI constructor 
	public GUI() {
		
		// create frame/window
		frame = new JFrame();
		frame.setResizable(false); // prevents resizing
		Dimension frameSize = new Dimension(1000, 700);
		frame.setPreferredSize(frameSize);
		ImageIcon icon = new ImageIcon("/icon2.png");
		frame.setIconImage(icon.getImage());
		
		// create tabs
		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(0,0,0,0);
		
		// create pages
		JPanel liveDataPage = new LiveDataPage().createLiveDataPage();
		JPanel createRecordPage = new CreateRecordPage().createCreateRecordPage();
		
		// add pages to tabs
		tabs.add("Live Data", liveDataPage);
		tabs.add("Create a Record", createRecordPage);
		frame.add(tabs);
		
		// GUI initialisation
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // allows processes to end before quitting 
		frame.setTitle("Monomer Data");
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); // centres the window		
	}

	
}	
	

