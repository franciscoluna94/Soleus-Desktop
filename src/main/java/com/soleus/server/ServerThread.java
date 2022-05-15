package com.soleus.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.crypto.spec.DHPrivateKeySpec;

import com.soleus.hibernate.UserModelDAO;
import com.soleus.hibernate.RoomRequestDAO;
import com.soleus.models.ClientRequest;
import com.soleus.models.RoomRequest;
import com.soleus.models.ServerAnswer;
import com.soleus.models.UserModel;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

public class ServerThread extends Thread {

	/* Socket utils */
	private static ServerSocket serverSocket;
	protected Socket clientSocket;
	ObjectInputStream reader;
	ObjectOutputStream writer;

	/* Models */
	private ClientRequest clientRequest;
	private UserModel userReceived;
	private UserModel userLogged;
	private RoomRequest request;
	private List<RoomRequest> requestList;
	private List<UserModel> userList;

	/* Server Answers */
	private final String typeOfAnswerSuccess = "OK";
	private final String typeOfAnswerFail = "FAIL";
	private ServerAnswer successAnswer = new ServerAnswer(typeOfAnswerSuccess, "");
	private ServerAnswer failAnswer = new ServerAnswer(typeOfAnswerFail, "");
	private ServerAnswer failAnswer_forbidden = new ServerAnswer(typeOfAnswerFail, "FORBIDDEN");

	/* Type of client requests */
	private String requestType;
	private final String loginRequest = "LOGIN";
	private final String saveRequest = "ROOM_REQUEST";
	private final String endRequest = "END_REQUEST";
	private final String getPendingRequests = "GET_RR_LIST";
	private final String getUsers = "GET_UM_LIST";
	private final String deleteUser = "DELETE_USER";
	private final String createUser = "CREATE_USER";
	private final String modifyUser = "MODIFY_USER";
	private final String getUser = "GET_USER";
	private final String changePassword = "CHANGE_PASSWORD";
	private final String filterRequestList = "GET_FILTER_RR";

	/* String utils */
	private final String housekeepingDepartment = "HOUSEKEEPING";
	private final String maintenanceDepartment = "MAINTENANCE";

	/* Hibernate and hibernate results */
	private UserModelDAO hibernateUsers;
	private RoomRequestDAO hibernateRequests;

	public ServerThread() {
	}

	public void run() {

		try {
			
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
			} else if (requestType.equals(getUsers)) {
				getUserModelList(writer, reader);
			} else if (requestType.equals(deleteUser)) {
				deleteUserModel(writer, reader);
			} else if (requestType.equals(createUser)) {
				createUserModel(writer, reader);
			} else if (requestType.equals(modifyUser)) {
				updateUserModel(writer, reader);
			} else if (requestType.equals(getUser)) {
				getUser(writer, reader);
			} else if (requestType.equals(changePassword)) {
				updatePassword(writer, reader);
			}else if (requestType.equals(filterRequestList)) {
				getFilteredRoomRequestList(writer, reader);
			}
			}


		} catch (IOException ex) {
			ex.printStackTrace(); // DEBUG
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} // end run

	private void checkUserLogin(ObjectOutputStream output, ObjectInputStream inputStreamReader)
			throws IOException, ClassNotFoundException {

		System.out.println("cliente conectado"); // DEBUG

		userReceived = (UserModel) reader.readObject();

		hibernateUsers = new UserModelDAO();
		hibernateRequests = new RoomRequestDAO();

		if (hibernateUsers.checkUserCredentials(userReceived.getUser(), userReceived.getPassword())) {

			writer.writeObject(successAnswer);
			userLogged = hibernateUsers.getUserModel(userReceived.getUser());
			writer.writeObject(userLogged);

			if (userLogged.getDepartment().equals(housekeepingDepartment)
					|| userLogged.getDepartment().equals(maintenanceDepartment)) {
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
		request.setRequestEndDate("Pendiente");
		String date = getTime();
		request.setRequestDate(date);
		

		hibernateRequests = new RoomRequestDAO();

		hibernateRequests.saveRequest(request);
		writer.writeObject(successAnswer);

		clientSocket.close();

	} // end saveRequest

	private void endRoomRequest(ObjectOutputStream output, ObjectInputStream inputStreamReader)
			throws IOException, ClassNotFoundException {

		request = (RoomRequest) reader.readObject();

		hibernateRequests = new RoomRequestDAO();

		String endDate = getTime();
		hibernateRequests.endRequest(request, endDate);
		writer.writeObject(successAnswer);

		clientSocket.close();

	} // end saveRequest

	private void getFilteredRoomRequestList(ObjectOutputStream output, ObjectInputStream inputStreamReader)
			throws IOException, ClassNotFoundException {

		request = (RoomRequest) reader.readObject();
		hibernateRequests = new RoomRequestDAO();
		requestList = hibernateRequests.getRequestList(request);
		writer.writeObject(requestList);
		clientSocket.close();

	} // end getFilteredRoomRequestList
	
	private void getRoomRequestList(ObjectOutputStream output, ObjectInputStream inputStreamReader)
			throws IOException, ClassNotFoundException {

		userLogged = (UserModel) reader.readObject();
		hibernateRequests = new RoomRequestDAO();
		requestList = hibernateRequests.getRequestList(userLogged);
		writer.writeObject(requestList);
		clientSocket.close();

	} // end getRoomRequestList

	private void getUserModelList(ObjectOutputStream output, ObjectInputStream inputStreamReader)
			throws IOException, ClassNotFoundException {

		hibernateUsers = new UserModelDAO();
		userList = hibernateUsers.getUserList();
		writer.writeObject(userList);
		clientSocket.close();

	} // end getRoomRequestList

	private void deleteUserModel(ObjectOutputStream output, ObjectInputStream inputStreamReader)
			throws IOException, ClassNotFoundException {

		userReceived = (UserModel) reader.readObject();

		hibernateUsers = new UserModelDAO();

		hibernateUsers.deleteUserModel(userReceived);

		clientSocket.close();

	} // end saveRequest

	private void createUserModel(ObjectOutputStream output, ObjectInputStream inputStreamReader)

			throws IOException, ClassNotFoundException {

		userReceived = (UserModel) reader.readObject();

		hibernateUsers = new UserModelDAO();

		hibernateUsers.saveUser(userReceived);
		writer.writeObject(successAnswer);

		clientSocket.close();

	} // end saveRequest

	private void updateUserModel(ObjectOutputStream output, ObjectInputStream inputStreamReader)
			throws IOException, ClassNotFoundException {

		userReceived = (UserModel) reader.readObject();

		hibernateUsers = new UserModelDAO();

		hibernateUsers.updateUser(userReceived);
		writer.writeObject(successAnswer);

		clientSocket.close();

	} // end updateUserModel

	private void getUser(ObjectOutputStream output, ObjectInputStream inputStreamReader)

			throws IOException, ClassNotFoundException {

		userReceived = (UserModel) reader.readObject();

		hibernateUsers = new UserModelDAO();

		UserModel userToSend = hibernateUsers.getUser(userReceived);
		writer.writeObject(userToSend);

		clientSocket.close();

	} // end getUser

	private void updatePassword(ObjectOutputStream output, ObjectInputStream inputStreamReader)
			throws IOException, ClassNotFoundException {

		System.out.println("cliente conectado"); // DEBUG

		userReceived = (UserModel) reader.readObject();

		hibernateUsers = new UserModelDAO();
		hibernateRequests = new RoomRequestDAO();

		if (hibernateUsers.checkUserName(userReceived.getUser(), userReceived.getName())) {
			if (hibernateUsers.updateUserPassword(userReceived.getUser(), userReceived.getPassword())) {
				writer.writeObject(successAnswer);
				userLogged = hibernateUsers.getUserModel(userReceived.getUser());
				writer.writeObject(userLogged);

				if (userLogged.getDepartment().equals(housekeepingDepartment)
						|| userLogged.getDepartment().equals(maintenanceDepartment)) {
					requestList = hibernateRequests.getRequestList(userLogged);
					writer.writeObject(requestList);
				}
			} else {
				writer.writeObject(failAnswer_forbidden);
				System.out.println("Doing forbidden"); // DEBUG
			}

		} else {
			writer.writeObject(failAnswer);
		}

		clientSocket.close();
		System.out.println("cliente desconectado"); // DEBUG

	} // end updatePassword
	
	private String getTime() {
		LocalTime time =  LocalTime.now();
		LocalTime requestHour = time.truncatedTo(ChronoUnit.MINUTES);
		LocalDate day = LocalDate.now();		
		day.format(DateTimeFormatter
			    .ofLocalizedDate(FormatStyle.SHORT));
		String formattedDate = day.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
		String date = requestHour.toString() + " " + formattedDate;
		return date;
	}

}
