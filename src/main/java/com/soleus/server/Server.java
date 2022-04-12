package com.soleus.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

// declaring required variables
	private static ServerSocket serverSocket;
	private static Socket clientSocket;

	public static void main(String[] args) {

		try {
			// creating a new ServerSocket at port 4444
			serverSocket = new ServerSocket(4444);

		} catch (IOException e) {
			System.out.println("Could not listen on port: 4444");   // DEBUG
		}

		System.out.println("Server started. Listening to the port 4444");   // DEBUG

		while (true) {
			try {

				clientSocket = serverSocket.accept();

			} catch (IOException ex) {
				System.out.println("Problem in message reading");  // DEBUG
			}
			ServerThread server = new ServerThread(clientSocket);

			server.start();

		}
	}
}