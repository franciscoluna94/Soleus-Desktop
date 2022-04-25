package com.soleus.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

import com.soleus.hibernate.UserModelDAO;
import com.soleus.hibernate.RoomRequestDAO;
import com.soleus.models.ClientRequest;
import com.soleus.models.RoomRequest;
import com.soleus.models.ServerAnswer;
import com.soleus.models.UserModel;

public class ServerThread extends Thread {

	/* Socket utils */
	protected Socket clientSocket;
	ObjectInputStream reader;
	ObjectOutputStream writer;	

	/* Models */
	private ClientRequest clientRequest;
	private UserModel userToCheck;
	private UserModel userLogged;
	private RoomRequest request;
	private List<RoomRequest> requestList;
	
	/* Server Answers */
	private final String typeOfAnswerSuccess = "OK";
	private final String typeOfAnswerFail = "FAIL";
	private ServerAnswer successAnswer = new ServerAnswer(typeOfAnswerSuccess, "");
	private ServerAnswer failAnswer = new ServerAnswer(typeOfAnswerFail, "");
	
	/* Type of client requests */
	private String requestType;
	private String loginRequest = "LOGIN";
	private String saveRequest = "ROOM_REQUEST";
	private String endRequest = "END_REQUEST";
	private String getPendingRequests = "GET_RR_LIST";
	
	/* String utils */
	private String housekeepingDepartment = "HOUSEKEEPING";
	private String maintenanceDepartmentString = "MAINTENANCE";

	/* Hibernate and hibernate results  */
	private UserModelDAO hibernateUsers;
	private RoomRequestDAO hibernateRequests;

	
	
	public ServerThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	
	public void run() {


		
		try {
			
			OutputStream output = clientSocket.getOutputStream();
	        InputStream input = clientSocket.getInputStream();
	        writer = new ObjectOutputStream(output);
	        reader = new ObjectInputStream(input);
	        
	        clientRequest = (ClientRequest) reader.readObject();
	        requestType = clientRequest.getRequestType();
	        
	        if (requestType.equals(loginRequest)) {
	        	checkUserLogin(writer, reader);
	        } else if (requestType.equals(saveRequest)) {
	        	saveRoomRequest(writer, reader);
	        } else if (requestType.equals(endRequest)) {
	        	endRoomRequest(writer, reader);
	        } else if (requestType.equals(getPendingRequests)) {
	        	getRoomRequestList(writer, reader);
	        } 
	        
		} catch (IOException ex) {
			ex.printStackTrace();  // DEBUG
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
	} // end run

	
	private void checkUserLogin(ObjectOutputStream output, ObjectInputStream inputStreamReader)
			throws IOException, ClassNotFoundException {

		System.out.println("cliente conectado"); // DEBUG
		
		userToCheck = (UserModel) reader.readObject();
		
		hibernateUsers = new UserModelDAO();
		hibernateRequests = new RoomRequestDAO();	
		
		if (hibernateUsers.checkUserCredentials(userToCheck.getUser(), userToCheck.getPassword())) {
			
			writer.writeObject(successAnswer);
			userLogged = hibernateUsers.getUserModel(userToCheck.getUser());
			writer.writeObject(userLogged);
			
			if (userLogged.getDepartment().equals(housekeepingDepartment) ||
					userLogged.getDepartment().equals(maintenanceDepartmentString)) {
				requestList = hibernateRequests.getRequestList(userLogged);
				writer.writeObject(requestList);			
			}			
			
		} else {
			writer.writeObject(failAnswer);
		}

		clientSocket.close();
		System.out.println("cliente desconectado"); // DEBUG

	} // end checkUserLogin

	private void saveRoomRequest(ObjectOutputStream output, ObjectInputStream inputStreamReader)

			throws IOException, ClassNotFoundException {
		
		request = (RoomRequest) reader.readObject();
		request.setRequestEnded(false);
		
		hibernateRequests = new RoomRequestDAO();
		
		hibernateRequests.saveRequest(request);	
		writer.writeObject(successAnswer);
		
		clientSocket.close();

	} // end saveRequest
	
	private void endRoomRequest(ObjectOutputStream output, ObjectInputStream inputStreamReader)
			throws IOException, ClassNotFoundException {
		
		request = (RoomRequest) reader.readObject();
		
		hibernateRequests = new RoomRequestDAO();
		
		hibernateRequests.endRequest(request);	
		writer.writeObject(successAnswer);
		
		clientSocket.close();

	} // end saveRequest

	private void getRoomRequestList(ObjectOutputStream output, ObjectInputStream inputStreamReader)
			throws IOException, ClassNotFoundException {
		
		userLogged = (UserModel) reader.readObject();
		hibernateRequests = new RoomRequestDAO();	
		requestList = hibernateRequests.getRequestList(userLogged);
		writer.writeObject(requestList);				
		clientSocket.close();

	} // end getRoomRequestList
	
}
