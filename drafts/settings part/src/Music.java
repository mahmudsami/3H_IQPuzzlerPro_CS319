import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;
import java.net.URL;


public class Music extends JFrame {

	private JPanel musicPane;
	private JComboBox comboBox;
	private JButton stopButton, playButton;
	private AudioClip[] music; 
	private AudioClip current;
	private JButton buttonReturnBack;
	private JLabel labelMusicSelection;
	private String[] musicNames;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Music frame = new Music();
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
	public Music() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 640);
		musicPane = new JPanel();
		musicPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		musicPane.setLayout(new BorderLayout(0, 0));
		setContentPane(musicPane);
		
		URL url1, url2, url3, url4, url5, url6,url7, url8;
		url1 = url2 = url3 = url4 = url5 = url6 = url7 = url8 = null;
		try
		{
			url1 = new URL ("file", "localhost", "musics\\Uzeyir_Mehdizade-Sene_ne.wav");
			url2 = new URL ("file", "localhost", "musics\\Hey_Brother.wav");
			url3 = new URL ("file", "localhost", "musics\\Je_Veux.wav");
			url4 = new URL ("file", "localhost", "musics\\The_Mamas_The_Papas.wav");
			url5 = new URL ("file", "localhost", "musics\\Dream_is_Collapsing_Hans_Zimmer.wav");
			url6 = new URL ("file", "localhost", "musics\\eightiesJam.wav");
			url7 = new URL ("file", "localhost", "musics\\hitchcock.wav");
			url8 = new URL ("file", "localhost", "musics\\classical.wav");
		}
		catch (Exception exception) {exception.printStackTrace();}
		music = new AudioClip[9];
		music[0] = null;  // Corresponds to "Make a Selection..."
		music[1] = JApplet.newAudioClip (url1);
		music[2] = JApplet.newAudioClip (url2);
		music[3] = JApplet.newAudioClip (url3);
		music[4] = JApplet.newAudioClip (url4);
		music[5] = JApplet.newAudioClip (url5);
		music[6] = JApplet.newAudioClip (url6);
		music[7] = JApplet.newAudioClip (url7);
		music[8] = JApplet.newAudioClip (url8);


		musicNames = new String[] {"...", "Uzeyir Mehdizade - Sene ne",
				"Avicii - Hey Brother", "Zaz - Je Veux", "California Dreamin - The Mamas & The Papas",
				"Dream is Collapsing - Hans Zimmer", "Alfred Hitchcock's Theme"};


		musicPane.setLayout(null);
		musicPane.setPreferredSize(new Dimension(400, 700));

		 labelMusicSelection = new JLabel("Music");
		 labelMusicSelection.setHorizontalAlignment(SwingConstants.CENTER);
		labelMusicSelection.setForeground(Color.WHITE);
		labelMusicSelection.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		labelMusicSelection.setBounds(41, 11, 319, 62);
		musicPane.add(labelMusicSelection);

		buttonReturnBack = new JButton("");
		buttonReturnBack.setIcon(new ImageIcon("images\\rsz_go-back-icon-md.png"));
		buttonReturnBack.setContentAreaFilled(false);
		buttonReturnBack.setBorder(new LineBorder(Color.WHITE, 0));
		buttonReturnBack.setBounds(10, 549, 45, 40);
		musicPane.add(buttonReturnBack);

		comboBox = new JComboBox(musicNames);
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		comboBox.setForeground(Color.BLACK);
		comboBox.setAlignmentX (Component.CENTER_ALIGNMENT);
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(10, 250, 380, 31);
		musicPane.add(comboBox);

		JPanel buttons = new JPanel();
		buttons.setLayout (new BoxLayout (buttons, BoxLayout.X_AXIS));
		buttons.add (Box.createRigidArea (new Dimension(5,0)));
		buttons.setBackground (Color.cyan);
		add (buttons);

		playButton = new JButton ("", new ImageIcon("images\\rsz_play.png"));
		playButton.setBorder( new LineBorder(Color.WHITE, 0));
		playButton.setContentAreaFilled(false);
		musicPane.add(playButton);
//		playButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
//		playButton.setBackground (Color.WHITE);
		playButton.setMnemonic ('p');
		playButton.setBounds(72, 327, 86, 64);
		
		stopButton = new JButton ("", new ImageIcon("images\\rsz_pause.png"));
		stopButton.setBorder( new LineBorder(Color.WHITE, 0));
		stopButton.setContentAreaFilled(false);
		musicPane.add(stopButton);
		stopButton.setBackground (Color.white);
		stopButton.setMnemonic ('s');
		stopButton.setBounds(219, 328, 86, 64);

		JLabel labelBackGround = new JLabel("");
		labelBackGround.setIcon(new ImageIcon("images\\background_Settings.jpg"));
		labelBackGround.setBounds(0, 0, 400, 600);
		musicPane.add(labelBackGround);
		comboBox.addActionListener (new ComboListener());
		stopButton.addActionListener (new ButtonListener());
		playButton.addActionListener (new ButtonListener());

		current = music[5];
		current.loop();
	}
	class ComboListener implements ActionListener
	{
		//--------------------------------------------------------------
		//  Stops playing the current selection (if any) and resets
		//  the current selection to the one chosen.
		//--------------------------------------------------------------
		public void actionPerformed (ActionEvent event)
		{
			if (current != null)
				current.stop();

			current = music[comboBox.getSelectedIndex()];
		}
	}
	class ButtonListener implements ActionListener
	{
		//--------------------------------------------------------------
		//  Stops the current selection (if any) in either case. If
		//  the play button was pressed, start playing it again.
		//--------------------------------------------------------------
		public void actionPerformed (ActionEvent event)
		{
			if (current != null)
				current.stop();

			if (event.getSource() == playButton)
				if (current != null)
					current.loop();
		}
	}

}
