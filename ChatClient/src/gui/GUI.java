package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.*;

public class GUI {

	Client client = new Client("127.0.0.1", 9000);
	
	JFrame frame = new JFrame();
	
	JPanel panel = new JPanel();
	
	JPanel title = new JPanel();
	JLabel titleLabel = new JLabel("chat :D");
	
	JPanel text = new JPanel();
	public static JTextArea textArea = new JTextArea(25,31);
	JScrollPane scroll = new JScrollPane(textArea);
	
	JPanel input = new JPanel();
	JPanel inputText = new JPanel();
	JTextArea inputT = new JTextArea(3,25);
	JPanel inputButton = new JPanel();
	JButton inputB = new JButton("입력");
	JPanel clear = new JPanel();
	JButton clearB = new JButton("리셋");
	
	public GUI(){

		title.setPreferredSize(new Dimension(360,30));
		title.add(titleLabel);
		
		textArea.setEditable(false);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		text.add(scroll);
		
		inputT.setBorder(new JTextField().getBorder());
		inputText.add(inputT);
		
		inputB.setPreferredSize(new Dimension(60,50));
		inputButton.add(inputB);
		
		inputB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(inputT.getText().equals(""))) {
					textArea.append("나 : " + inputT.getText() + "\n");
					textArea.setCaretPosition(textArea.getDocument().getLength());
					try {
						client.write(inputT.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					inputT.setText("");
				}
			}
		});
		inputT.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if (e.isShiftDown()) { // Shift + Enter = 줄 바꿈
						inputT.append(System.lineSeparator());
					}
					else { // Enter = 전송
						if(!(inputT.getText().equals(""))) {
							textArea.append("나 : " + inputT.getText() + "\n");
							textArea.setCaretPosition(textArea.getDocument().getLength());
							try {
								client.write(inputT.getText());
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							inputT.setText("");
						}
						// stop event
					}
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		input.add(inputText);
		input.add(inputButton);
		
		clearB.setPreferredSize(new Dimension(360,30));
		clear.add(clearB);
		clearB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		
		panel.add(title);
		panel.add(text);
		panel.add(input);
		panel.add(clear);
			
		frame.add(panel);
			
		frame.setTitle("chat");
		frame.setSize(400, 620);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}