package userInterfaceController;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;
import java.net.URL;
import java.applet.AudioClip;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SettingsMenuu extends JFrame {

    private AudioClip[] music;
    private AudioClip current;
    private String[] musicNames;
    private JPanel contentPane;
    /**
     * Create the frame.
     */
    public SettingsMenuu() {
        setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 340);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel SettingsLabel = new JLabel("Settings ");
        SettingsLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
        SettingsLabel.setForeground(Color.BLACK);
        SettingsLabel.setBounds(156, 11, 90, 30);
        contentPane.add(SettingsLabel);


        JLabel lblNewLabel = new JLabel("Rotate to Left");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setBounds(90, 208, 90, 14);
        contentPane.add(lblNewLabel);

        JLabel lblRotateToRight = new JLabel("Rotate to right");
        lblRotateToRight.setBounds(90, 222, 90, 14);
        contentPane.add(lblRotateToRight);

        JLabel lblRotateUp = new JLabel("Rotate UP");
        lblRotateUp.setBounds(90, 236, 90, 14);
        contentPane.add(lblRotateUp);

        JLabel lblPause = new JLabel("Rotate DOWN");
        lblPause.setBounds(90, 250, 90, 14);
        contentPane.add(lblPause);

        JLabel lblPause_1 = new JLabel("Pause");
        lblPause_1.setBounds(90, 264, 90, 14);
        contentPane.add(lblPause_1);

        JLabel lblRestart = new JLabel("Restart");
        lblRestart.setBounds(90, 278, 90, 14);
        contentPane.add(lblRestart);

        JLabel lblKeys = new JLabel("KEYS");
        lblKeys.setFont(new Font("Viner Hand ITC", Font.PLAIN, 14));
        lblKeys.setHorizontalAlignment(SwingConstants.CENTER);
        lblKeys.setBounds(166, 174, 42, 23);
        contentPane.add(lblKeys);

        JButton lblMusic = new JButton("Music");
        lblMusic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        lblMusic.setFont(new Font("Viner Hand ITC", Font.BOLD, 14));
        lblMusic.setBounds(102, 79, 186, 23);
        contentPane.add(lblMusic);

        JButton lblLanguage = new JButton("Language");
        lblLanguage.setFont(new Font("Viner Hand ITC", Font.BOLD, 14));
        lblLanguage.setBounds(103, 119, 186, 23);
        contentPane.add(lblLanguage);

    }
    public JPanel returnPanel()
    {
        return contentPane;
    }
}
