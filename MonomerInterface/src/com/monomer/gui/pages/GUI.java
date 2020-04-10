package com.monomer.gui.pages;

import com.monomer.data.DataObject;

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
	
	private JFrame mainFrame;
	// private JPanel liveDataPage;
	private JPanel createRecordTab;
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
	private JComboBox<String> machineText;
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
		
		// Frame set up
		mainFrame = new JFrame();
		mainFrame.setResizable(false); // prevents resizing
		Dimension frameSize = new Dimension(1000, 700);
		mainFrame.setPreferredSize(frameSize);
		ImageIcon icon = new ImageIcon("/icon2.png");
		mainFrame.setIconImage(icon.getImage());
		
		// Tabs set up
		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(0,0,0,0);
		
//		JPanel liveDataPage = new JPanel(new GridBagLayout());
//		liveDataPage.setBorder(new LineBorder(Color.RED, 1, true));

		JPanel liveDataPage = new LiveDataPage().createLiveDataPage();
		
		
		// createRecordPage = new CreateRecordPage();
		
		tabs.add("Live Data", liveDataPage);
		tabs.add("Create a Record", createRecordTab);
		mainFrame.add(tabs);
		
		// GUI initialisation
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // allows processes to end before quitting 
		mainFrame.setTitle("Monomer Data");
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null); // centres the window		
	}

	
}	
	

