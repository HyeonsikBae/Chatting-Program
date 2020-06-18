package thread;

import java.net.Socket;
import java.util.ArrayList;

import gui.GUI;

public class SocketThread extends Thread {

	private Socket socket;
	private ArrayList<Socket> connectList;
	public SocketThread(Socket socket, ArrayList<Socket> connectList) {
		this.socket = socket;
		this.connectList = connectList;
	}
	
	public void run() {
		super.run();
		
		try {
			connectList.add(socket);
			GUI.textArea.append("Connect IP\t: "+socket.getInetAddress()+"\n");
			GUI.textArea.append("Connect Port\t: "+socket.getPort()+"\n");
			
			new ServerThread(socket,connectList).start();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
