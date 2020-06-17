package main;
import java.util.Scanner;

import server.*;

public class main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int portNumber = 0;
		System.out.print("접속할 포트 번호 입력 : ");
		portNumber = scanner.nextInt();
		
		Server.setPortNumber(portNumber);
		new Server(Server.getPortNumber());
		scanner.close();
	}
}