package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import gui.GUI;

public class ClientThread extends Thread{
	
	Socket socket = new Socket();
	
	public ClientThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		super.run();
		try {
			while(true) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String packet = reader.readLine();
			GUI.textArea.append(socket.getInetAddress() + " : " + packet + "\n");
			GUI.textArea.setCaretPosition(GUI.textArea.getDocument().getLength());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}