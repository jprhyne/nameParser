package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Robot;
import java.awt.AWTException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;

import io.NameParserIO;

public class NameParserGUI extends JFrame implements ActionListener {
	
	/**
	 * Defines the number of rows in the panel
	 */
	private final int NUM_ROWS = 2;
	
	/**
	 * Defines the number of columns in the panel
	 */
	private final int NUM_COLS = 3;
	
	/**
	 * Start button for the program
	 */
	private static JButton start;
	
	/**
	 * Help button for the program
	 */
	private static JButton help;
	
	/**
	 * Quit button for the program
	 */
	private static JButton quit;
	
	/**
	 * Button that displays the License
	 */
	private static JButton license;
	
	
	
	/**
	 * Frame where everything is placed
	 */
	private static JFrame frame;
	
	
	/**
	 * 2D array that will hold all of our Buttons for ease of access
	 * and modification
	 */
	private JPanel[][] panelHolder;
	
	public NameParserGUI() {
		super();
		frame = new JFrame();
		frame.setSize(500, 100);
		frame.setLocation(900, 200);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initializeGUI();
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
	}
	
	private void initializeGUI() {
		// Initialize the panelHolder variable
		panelHolder = new JPanel[NUM_ROWS][NUM_COLS];
		// Initialize the frame to hold all the panels  
		frame.setLayout(new GridLayout(NUM_ROWS,NUM_COLS));
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
				// Construct each JPanel and store them 
				panelHolder[i][j] = new JPanel();
				frame.add(panelHolder[i][j]);
			}
		}
		// Construct our buttons
		start = new JButton("Start");
		help = new JButton("Help");
		quit = new JButton("Quit");
		license = new JButton("License");
		
		
		//add an action listener to the buttons so we can know when they are pressed
		start.addActionListener(this);
		help.addActionListener(this);
		quit.addActionListener(this);
		license.addActionListener(this);
		
		// Add our newly created buttons to the holder and then to the display
		panelHolder[0][0].add(start);
		panelHolder[0][1].add(help);
		panelHolder[0][2].add(quit);
		panelHolder[1][1].add(license);
	}

	public static void main(String[] args) {
		new NameParserGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == quit) {
			System.exit(0);
		} else if (e.getSource() == help) {
			JOptionPane.showMessageDialog(frame, "To use this program, you must first have \n"
					+ "1) A master student file\n2) Some of \"filter\" files");
		} else if (e.getSource() == license) {
			JOptionPane.showMessageDialog(frame, "This program is licensed under GPLV3 or later.\nFor more information"
					+ "visit https://github.com/jprhyne/nameParser.");
		} else if (e.getSource() == start) {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
			fileChooser.setFileFilter(filter);
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			fileChooser.setDialogTitle("Master Student List");
			int ret = fileChooser.showOpenDialog(fileChooser);
			if (ret == JFileChooser.APPROVE_OPTION) {
				// This means the user properly selected a file to open
				String masterListName = fileChooser.getSelectedFile().getName();
				// Try to parse this as a CSV file using nameParser.io.NameParserIO
				try {
					NameParserIO.createMasterStudentList(masterListName);
				} catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(frame, "This file is not of the correct format. "
							+ "Try a different master list.\nThe given error was reported:\n"
							+ iae.getMessage());
				}
			}
		}
	}
}
