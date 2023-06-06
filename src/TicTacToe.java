import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.sound.sampled.*;

public class TicTacToe implements ActionListener {
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1Turn;
	boolean isGameStarted;
    Clip backgroundMusic;
    
    TicTacToe() {
    	// Set the close operation of the JFrame
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	// Set the size of the JFrame
    	frame.setSize(800, 800);
    	// Set the background color of the JFrame
    	frame.getContentPane().setBackground(new Color(50, 50, 50));
    	// Set the layout of the JFrame
    	frame.setLayout(new BorderLayout());
    	// Make the JFrame visible
    	frame.setVisible(true);
    	
    	// Set the background color, font, and alignment of the textField
    	textField.setBackground(new Color(25, 25, 25));
    	textField.setForeground(new Color(25, 255, 0));
    	textField.setFont(new Font("Chalkboard", Font.BOLD, 75));
    	textField.setHorizontalAlignment(JLabel.CENTER);
    	textField.setText("Tic-Tac-Toe");
    	textField.setOpaque(true);
    	
    	// Set the layout and bounds of the title panel
    	titlePanel.setLayout(new BorderLayout());
    	titlePanel.setBounds(0, 0, 800, 100);
    	
    	// Set the layout and background color of the button panel
    	buttonPanel.setLayout(new GridLayout(3, 3));
    	buttonPanel.setBackground(new Color(150, 150, 150));
    	
    	// Create buttons, set their font and properties, and add action listener
    	for (int i = 0; i < 9; i++) {
    		buttons[i] = new JButton();
    		buttonPanel.add(buttons[i]);
    		buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
    		buttons[i].setFocusable(false);
    		buttons[i].addActionListener(this);
    	}
    	
    	// Add the textField to the title panel and add title panel and button panel to the frame
    	titlePanel.add(textField);
    	frame.add(titlePanel, BorderLayout.NORTH);
    	frame.add(buttonPanel);
    	
    	// Start the game by determining the first turn
    	firstTurn();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	// Handle button clicks
    	for (int i = 0; i < 9; i++) {
    		if (e.getSource() == buttons[i]) {
    			if (player1Turn) {
    				if (buttons[i].getText().equals("")) {
    					buttons[i].setForeground(new Color(255, 0, 0));
    					buttons[i].setText("X");
    					player1Turn = false;
    					textField.setText("O turn");
    					check();
    				}
    			}
    			else {
    				if (buttons[i].getText().equals("")) {
    					buttons[i].setForeground(new Color(0, 0, 255));
    					buttons[i].setText("O");
    					player1Turn = true;
    					textField.setText("X turn");
    					check();
    				}
    			}
    		}
    	}
    }
    
    public void firstTurn() {
    	// Pause for 2 seconds before determining the first turn
    	try {
    		Thread.sleep(2000);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    	// Randomly choose which player goes first
    	if (random.nextInt(2) == 0) {
    		player1Turn = true;
    		textField.setText("X Turn");
    	}
    	else {
    		player1Turn = false;
    		textField.setText("O Turn");
    	}
    }
    
    public void check() {
    	// Check for X win conditions
    	if (
    			(buttons[0].getText().equals("X")) &&
    			(buttons[1].getText().equals("X")) &&
    			(buttons[2].getText().equals("X"))
    			) {
    		xWins(0, 1, 2);
    	}
    	if (
    			(buttons[3].getText().equals("X")) &&
    			(buttons[4].getText().equals("X")) &&
    			(buttons[5].getText().equals("X"))
    			) {
    		xWins(3, 4, 5);
    	}
    	if (
    			(buttons[6].getText().equals("X")) &&
    			(buttons[7].getText().equals("X")) &&
    			(buttons[8].getText().equals("X"))
    			) {
    		xWins(6, 7, 8);
    	}
    	if (
    			(buttons[0].getText().equals("X")) &&
    			(buttons[3].getText().equals("X")) &&
    			(buttons[6].getText().equals("X"))
    			) {
    		xWins(0, 3, 6);
    	}
    	if (
    			(buttons[1].getText().equals("X")) &&
    			(buttons[4].getText().equals("X")) &&
    			(buttons[7].getText().equals("X"))
    			) {
    		xWins(1, 4, 7);
    	}
    	if (
    			(buttons[2].getText().equals("X")) &&
    			(buttons[5].getText().equals("X")) &&
    			(buttons[8].getText().equals("X"))
    			) {
    		xWins(2, 5, 8);
    	}
    	if (
    			(buttons[0].getText().equals("X")) &&
    			(buttons[4].getText().equals("X")) &&
    			(buttons[8].getText().equals("X"))
    			) {
    		xWins(0, 4, 8);
    	}
    	if (
    			(buttons[2].getText().equals("X")) &&
    			(buttons[4].getText().equals("X")) &&
    			(buttons[6].getText().equals("X"))
    			) {
    		xWins(2, 4, 6);
    	}
    	// Check for O win conditions
    	if (
    			(buttons[0].getText().equals("O")) &&
    			(buttons[1].getText().equals("O")) &&
    			(buttons[2].getText().equals("O"))
    			) {
    		oWins(0, 1, 2);
    	}
    	if (
    			(buttons[3].getText().equals("O")) &&
    			(buttons[4].getText().equals("O")) &&
    			(buttons[5].getText().equals("O"))
    			) {
    		oWins(3, 4, 5);
    	}
    	if (
    			(buttons[6].getText().equals("O")) &&
    			(buttons[7].getText().equals("O")) &&
    			(buttons[8].getText().equals("O"))
    			) {
    		oWins(6, 7, 8);
    	}
    	if (
    			(buttons[0].getText().equals("O")) &&
    			(buttons[3].getText().equals("O")) &&
    			(buttons[6].getText().equals("O"))
    			) {
    		oWins(0, 3, 6);
    	}
    	if (
    			(buttons[1].getText().equals("O")) &&
    			(buttons[4].getText().equals("O")) &&
    			(buttons[7].getText().equals("O"))
    			) {
    		oWins(1, 4, 7);
    	}
    	if (
    			(buttons[2].getText().equals("O")) &&
    			(buttons[5].getText().equals("O")) &&
    			(buttons[8].getText().equals("O"))
    			) {
    		oWins(2, 5, 8);
    	}
    	if (
    			(buttons[0].getText().equals("O")) &&
    			(buttons[4].getText().equals("O")) &&
    			(buttons[8].getText().equals("O"))
    			) {
    		oWins(0, 4, 8);
    	}
    	if (
    			(buttons[2].getText().equals("O")) &&
    			(buttons[4].getText().equals("O")) &&
    			(buttons[6].getText().equals("O"))
    			) {
    		oWins(2, 4, 6);
    	}
    }
    
    public void xWins(int a, int b, int c) {
    	// Highlight the buttons that caused the win
    	buttons[a].setBackground(Color.GREEN);
    	buttons[b].setBackground(Color.GREEN);
    	buttons[c].setBackground(Color.GREEN);
    	
    	// Disable all buttons
    	for (int i = 0; i < 9; i++) {
    		buttons[i].setEnabled(false);
    	}
    	// Update the text field
    	textField.setText("X Wins");
    }
    
    public void oWins(int a, int b, int c) {
    	// Highlight the buttons that caused the win
    	buttons[a].setBackground(Color.GREEN);
    	buttons[b].setBackground(Color.GREEN);
    	buttons[c].setBackground(Color.GREEN);
    	
    	// Disable all buttons
    	for (int i = 0; i < 9; i++) {
    		buttons[i].setEnabled(false);
    	}
    	// Update the text field
    	textField.setText("O Wins");
    }
}
    
