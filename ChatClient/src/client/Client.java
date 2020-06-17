package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import gui.*;

import thread.ClientThread;

public class Client {
	static Socket socket = new Socket();
	private String ip = "";
	private int port = 0;
	
	public void write(String packet) throws IOException {
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		pw.println(packet);
		pw.flush();
	}
	
	public Client(String ipNumber, int portNumber) {
		try {
			InetSocketAddress socketAddr = new InetSocketAddress(ipNumber,portNumber);
			while(true) {
			socket.connect(socketAddr, 100);
			InetAddress inetAddr;
			if((inetAddr = socket.getInetAddress())!=null) {
				System.out.println("Server connect : " + inetAddr);
				GUI.textArea.append(inetAddr+" 접속 성공"+"\n");
			}else {
				System.out.println("Server connect fail");
				GUI.textArea.append("접속 실패");
			}
			new ClientThread(socket).start();
			}
		}
		catch(IOException e) {
			e.getStackTrace();
		}
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
