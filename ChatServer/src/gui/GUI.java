package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import server.*;

public class GUI {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel textPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	public static JTextArea textArea = new JTextArea(20,30);
	JScrollPane scroll = new JScrollPane(textArea);
	JButton exit = new JButton("종료");
	
	public GUI() {
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setEditable(false);
		textPanel.add(scroll);
		
		buttonPanel.add(exit);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		panel.add(textPanel);
		panel.add(buttonPanel);
		
		frame.add(panel);
		
		frame.setBounds(100, 100, 400, 420);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		new Server();
	}
}
