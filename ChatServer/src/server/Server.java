package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import thread.ServerThread;

public class Server {
	
	private static int portNumber;
	
	
	public Server(int portNumber) {
		
		Socket socket = new Socket();
		ArrayList<Socket> connectList = new ArrayList<Socket>();
		
		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			while(true) {
				System.out.println("접속 대기 중");
				socket = serverSocket.accept();
				connectList.add(socket);
				
				System.out.println("Connect IP\t: "+socket.getInetAddress());
				System.out.println("Connect Port\t: "+socket.getPort());
				
				new ServerThread(socket, connectList).start();
			}
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