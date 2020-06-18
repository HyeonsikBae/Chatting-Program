package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import thread.*;
import gui.*;

public class Server {
	
	private static int portNumber;
	
	public Server() {
		
		Socket socket = new Socket();
		ArrayList<Socket> connectList = new ArrayList<Socket>();
		
		
		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			GUI.textArea.append("연결 완료\n");
			
			new AcceptThread(socket, serverSocket, connectList).start();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int getPortNumber() {
		return portNumber;
	}

	public static void setPortNumber(int portNumber) {
		Server.portNumber = portNumber;
	}
}