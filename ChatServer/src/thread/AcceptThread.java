package thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class AcceptThread extends Thread {
	
	Socket socket;
	ServerSocket serverSocket;
	ArrayList<Socket> connectList;
	
	public AcceptThread(Socket socket, ServerSocket serverSocket, ArrayList<Socket> connectList) {
		super();
		this.socket = socket;
		this.serverSocket = serverSocket;
		this.connectList = connectList;
	}

	@Override
	public void run() {
		
		super.run();
		while(true) {
			try {
				socket = serverSocket.accept();
				if(socket != null) {
					new SocketThread(socket, connectList).start();
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}		
		}
	}
}
