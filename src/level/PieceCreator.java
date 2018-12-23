package level;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;

public class PieceCreator extends JFrame {
	int color = 0;
	int colorIndex = 0;
	int count = 0;
	int[] colorArray = new int[55];
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PieceCreator frame = new PieceCreator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PieceCreator() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFill = new JLabel("Fill the Blank with Color");
		lblFill.setFont(new Font("Calibri", Font.BOLD, 24));
		lblFill.setBounds(440, 83, 300, 51);
		contentPane.add(lblFill);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 161, 624, 319);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 11, 0, 0));
		
		JButton[] buttons = new JButton[55];
		for (int i = 0; i < 55; i++)
			buttons[i] = new JButton("");
		for (int i = 0; i < 55; i++)
			panel.add(buttons[i]);
		
		
		/**
		 *  Panel 1 created to keep radio buttons 
		 */
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(721, 161, 407, 319);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 4, 0, 0));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Red");
		rdbtnNewRadioButton_1.setBackground(Color.RED);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Light Gray");
		rdbtnNewRadioButton_2.setBackground(Color.LIGHT_GRAY);
		panel_1.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Magenta");
		rdbtnNewRadioButton_3.setBackground(Color.MAGENTA);
		panel_1.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Black");
		rdbtnNewRadioButton_4.setForeground(Color.WHITE);
		rdbtnNewRadioButton_4.setBackground(Color.BLACK);
		panel_1.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Yellow");
		rdbtnNewRadioButton_5.setBackground(Color.YELLOW);
		rdbtnNewRadioButton_5.setForeground(Color.BLACK);
		panel_1.add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Dark Gray");
		rdbtnNewRadioButton_6.setBackground(Color.DARK_GRAY);
		panel_1.add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("White");
		rdbtnNewRadioButton_7.setBackground(Color.WHITE);
		panel_1.add(rdbtnNewRadioButton_7);
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("Green");
		rdbtnNewRadioButton_8.setBackground(Color.GREEN);
		panel_1.add(rdbtnNewRadioButton_8);
		
		JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("Orange");
		rdbtnNewRadioButton_9.setBackground(Color.ORANGE);
		panel_1.add(rdbtnNewRadioButton_9);
		
		JRadioButton rdbtnNewRadioButton_10 = new JRadioButton("Pink");
		rdbtnNewRadioButton_10.setBackground(Color.PINK);
		panel_1.add(rdbtnNewRadioButton_10);
		
		JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("Cyan");
		rdbtnNewRadioButton_11.setBackground(Color.CYAN);
		panel_1.add(rdbtnNewRadioButton_11);
		
		JRadioButton rdbtnNewRadioButton_12 = new JRadioButton("Blue");
		rdbtnNewRadioButton_12.setForeground(Color.WHITE);
		rdbtnNewRadioButton_12.setBackground(Color.BLUE);
		panel_1.add(rdbtnNewRadioButton_12);
		
		
		ButtonGroup rdbg =new ButtonGroup();
		rdbg.add(rdbtnNewRadioButton_1);
		rdbg.add(rdbtnNewRadioButton_2);
		rdbg.add(rdbtnNewRadioButton_3);
		rdbg.add(rdbtnNewRadioButton_4);
		rdbg.add(rdbtnNewRadioButton_5);
		rdbg.add(rdbtnNewRadioButton_6);
		rdbg.add(rdbtnNewRadioButton_7);
		rdbg.add(rdbtnNewRadioButton_8);
		rdbg.add(rdbtnNewRadioButton_9);
		rdbg.add(rdbtnNewRadioButton_10);
		rdbg.add(rdbtnNewRadioButton_11);
		rdbg.add(rdbtnNewRadioButton_12);
		
		
		
		/**
		 *  Panel 2 created to keep options
		 */
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(352, 28, 414, 42);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnFlat = new JButton("Flat");
		panel_2.add(btnFlat);
		
		JButton btnDiagonal = new JButton("Diagonal");
		panel_2.add(btnDiagonal);
		
		JButton btnd = new JButton("3-D");
		panel_2.add(btnd);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(524, 558, 97, 25);
		contentPane.add(btnCheck);
		
		
		/**
		 *  Action listener created in order to paint buttons 
		 *  according to chosen radio button
		 */
		
		
		// action listener for radio button
		
		ActionListener radioButtonListener = new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	
		    	if (e.getSource() == rdbtnNewRadioButton_1) {
		    		color = 1; 	// red 1
		    		System.out.println(color);
		    	}
		    	if (e.getSource() == rdbtnNewRadioButton_2) {
		    		color = 2;	// light gray 2
		    		System.out.println(color);
		    	}
		    	if (e.getSource() == rdbtnNewRadioButton_3) {
		    		color = 3;	// blue 3
		    		System.out.println(color);
		    	}
		    	if (e.getSource() == rdbtnNewRadioButton_4) {
		    		color = 4;	// yellow 4
		    		System.out.println(color);
		    	}
		    	if (e.getSource() == rdbtnNewRadioButton_5)
		    		color = 5;	// green 5
		    	if (e.getSource() == rdbtnNewRadioButton_6)
		    		color = 6;	// pink 6
		    	if (e.getSource() == rdbtnNewRadioButton_7)
		    		color = 7;	// cyan 7
		    	if (e.getSource() == rdbtnNewRadioButton_8)
		    		color = 8;	// orange 8
		    	if (e.getSource() == rdbtnNewRadioButton_9)
		    		color = 9;	// magenta 9
		    	if (e.getSource() == rdbtnNewRadioButton_10)
		    		color = 10;	//white 10
		    	if (e.getSource() == rdbtnNewRadioButton_11)
		    		color = 11;	//dark gray 11
		    	if (e.getSource() == rdbtnNewRadioButton_12) {
		    		color = 12;  // nlue
		    		System.out.println(color);
		    	}
		    	
		    }
		};
		
		
		
		//rdbtnNewRadioButton.addActionListener( radioButtonListener );
		rdbtnNewRadioButton_1.addActionListener( radioButtonListener );
		rdbtnNewRadioButton_2.addActionListener( radioButtonListener );
		rdbtnNewRadioButton_3.addActionListener( radioButtonListener );
		rdbtnNewRadioButton_4.addActionListener( radioButtonListener );
		rdbtnNewRadioButton_5.addActionListener( radioButtonListener );
		rdbtnNewRadioButton_6.addActionListener( radioButtonListener );
		rdbtnNewRadioButton_7.addActionListener( radioButtonListener );
		rdbtnNewRadioButton_8.addActionListener( radioButtonListener );
		rdbtnNewRadioButton_9.addActionListener( radioButtonListener );
		rdbtnNewRadioButton_10.addActionListener( radioButtonListener );
		rdbtnNewRadioButton_11.addActionListener( radioButtonListener );
		rdbtnNewRadioButton_12.addActionListener( radioButtonListener );
		
		
		ActionListener buttonListener =new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	JButton buttonlistened = (JButton ) e.getSource();
		    	for (int i = 0; i <55; i++)
		    		if (buttonlistened == buttons[i])
		    			colorIndex = i;
		    		
//		    	if (buttonlistened.getModel().isPressed()) {
//					count++;
//					System.out.println(count);
//		    	}
		    	count++;
		    	//System.out.println(count);
		    	System.out.println(buttonlistened);
		    	if(color==4) {//0
		    		buttonlistened.setBackground(Color.BLACK);
		    		colorArray[colorIndex] = color;
		    	}
		    	if(color==1) {//1
		    		buttonlistened.setBackground(Color.RED);
		    		colorArray[colorIndex] = color;
		    	}
		    	if(color==2) {//2
		    		buttonlistened.setBackground(Color.LIGHT_GRAY);
		    		colorArray[colorIndex] = color;
		    	}
		    	if(color==12) {//3
		    		buttonlistened.setBackground(Color.BLUE);
		    		colorArray[colorIndex] = color;
		    	}
		    	if(color==5) {//4
		    		buttonlistened.setBackground(Color.YELLOW);
		    		colorArray[colorIndex] = color;
		    	}
		    	if(color==8) {//5
		    		buttonlistened.setBackground(Color.GREEN);
		    		colorArray[colorIndex] = color;
		    	}
		    	if(color==10) {//6
		    		buttonlistened.setBackground(Color.PINK);
		    		colorArray[colorIndex] = color;
		    	}
		    	if(color==11) {//7
		    		buttonlistened.setBackground(Color.CYAN);
		    		colorArray[colorIndex] = color;
		    	}
		    	if(color==9) {//8
		    		buttonlistened.setBackground(Color.ORANGE);
		    		colorArray[colorIndex] = color;
		    	}
		    	if(color==3) {//9
		    		buttonlistened.setBackground(Color.MAGENTA);
		    		colorArray[colorIndex] = color;
		    	}
		    	if(color==7) {//10
		    		buttonlistened.setBackground(Color.WHITE);
		    		colorArray[colorIndex] = color;
		    	}
		    	if(color==6) {//11
		    		buttonlistened.setBackground(Color.DARK_GRAY);
		    		colorArray[colorIndex] = color;
		    	}
		    	
		    }
		};
		
		for (int i = 0; i < 55; i++)
			buttons[i].addActionListener(buttonListener);
		
		
		
//		boolean checkBtn = false;
		ActionListener checkListener =new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	if (e.getSource() == btnCheck) {
					if (count >= 55) {
						//checkBtn = true;
						System.out.println("\ncheck is TRUE");
						for (int i = 0; i < 55; i++) {
							
							System.out.print(colorArray[i] + " ");
						}
					}else {
						System.out.println("\ncheck is FALSE");
					}
				}
		    }   
		};
		btnCheck.addActionListener(checkListener);
		

	}
	public int[] getColor() {
		return this.colorArray;
	}
}
