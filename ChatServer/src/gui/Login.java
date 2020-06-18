package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import server.*;

public class Login {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel portPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	
	JLabel portLabel = new JLabel("PORT : ");
	JTextField portField = new JTextField(5);
	
	JButton connect = new JButton("연결");
	JButton exit = new JButton("종료");
	
	public Login() {
		
		portPanel.add(portLabel);
		portPanel.add(portField);
		
		portField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					System.exit(0);
				}
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					Server.setPortNumber(Integer.parseInt(portField.getText()));
					frame.dispose(); 
					new GUI();		
				}
			}
		});
		
		buttonPanel.add(connect);
		buttonPanel.add(exit);
		
		connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Server.setPortNumber(Integer.parseInt(portField.getText()));
				frame.dispose(); 
				new GUI();				
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		panel.add(portPanel);
		panel.add(buttonPanel);
		
		frame.add(panel);
		frame.setBounds(100, 100, 200, 120);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
