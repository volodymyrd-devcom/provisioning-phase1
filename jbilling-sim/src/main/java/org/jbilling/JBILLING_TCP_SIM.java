package org.jbilling;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class JBILLING_TCP_SIM {

	public static void main(String argv[]) throws Exception {
		String clientSentence = "";
		String capitalizedSentence = "";
		ServerSocket welcomeSocket = new ServerSocket(8012);
		boolean isClose = false;
		while (!isClose) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			System.out.println("Received: " + clientSentence);
			if (clientSentence.indexOf("exit") != -1) {
				isClose = true;
				continue;
			} else if (clientSentence != null && clientSentence.indexOf("491772000001") != -1) {
				capitalizedSentence = "SUCCESS" + '\n';
			} else {
				capitalizedSentence = "FAULT" + '\n';
			}
			System.out.println("Sent: " + capitalizedSentence);
			outToClient.writeBytes(capitalizedSentence);
			outToClient.close();

			if (clientSentence.indexOf("exit") != -1)
				isClose = true;
		}
		welcomeSocket.close();
	}

}
