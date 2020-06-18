package thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import gui.*;

public class ServerThread extends Thread{
	
	Socket socket = new Socket();
	ArrayList<Socket> connectList = new ArrayList<Socket>();
	
	public ServerThread(Socket socket, ArrayList<Socket> connectList) {
		this.socket = socket;
		this.connectList = connectList;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			while(true) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String packet = reader.readLine();
				if(packet==null) break;
				GUI.textArea.append(socket.getInetAddress() + " : " + packet +"\n");
				
				for (int i = 0; i < connectList.size(); i++) {
					Socket connectSocket = connectList.get(i);
					if(connectSocket != socket) {
						PrintWriter writer = new PrintWriter(connectSocket.getOutputStream());
						writer.println(packet);
						writer.flush();
					}
				}
			}
		} catch (Exception e) {
			
			GUI.textArea.append(socket.getInetAddress() + " 연결 해제\n");
			connectList.remove(socket);
		}
		try {
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}