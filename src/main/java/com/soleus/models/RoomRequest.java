package com.soleus.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client_request")
public class RoomRequest implements Serializable {
	
	private static final long serialVersionUID = 3L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "request_id")
	private int requestId;
	@Column(name = "topic")
	private String requestTopic;
	@Column(name = "item")
	private String requestItem;
	@Column(name = "description")
	private String requestDescription;
	@Column(name = "department")
	private String requestDepartment;
	@Column(name = "client_room")
	private String clientRoom;
	@Column(name = "request_time")
	private String requestTime;
	@Column(name = "ended")
	private boolean requestEnded;
	

	public RoomRequest() {
		
	}
	
	public RoomRequest(int requestId, String requestTopic, String requestItem, String requestDescription, String requestDepartment,
			boolean requestEnded, String clientRoom, String requestTime) {
		this.requestId = requestId;
		this.requestTopic = requestTopic;
		this.requestItem = requestItem;
		this.requestDescription = requestDescription;
		this.requestDepartment = requestDepartment;
		this.requestEnded = requestEnded;
		this.clientRoom = clientRoom;
		this.requestTime = requestTime;
		
	}
	
	public RoomRequest(String requestTopic, String requestItem, String requestDescription, String requestDepartment,
			boolean requestEnded, String clientRoom) {
		this.requestTopic = requestTopic;
		this.requestItem = requestItem;
		this.requestDescription = requestDescription;
		this.requestDepartment = requestDepartment;
		this.requestEnded = requestEnded;
		this.clientRoom = clientRoom;
	}

    public RoomRequest(String requestTopic, String requestItem, String requestDescription, String requestDepartment,
            String clientRoom) {
    	this.requestTopic = requestTopic;
    	this.requestItem = requestItem;
    	this.requestDescription = requestDescription;
    	this.requestDepartment = requestDepartment;
    	this.clientRoom = clientRoom;
    }
    
    public RoomRequest(String requestItem) {
        this.requestItem = requestItem;
    }

	public String getRequestTopic() {
		return requestTopic;
	}

	public void setRequestTopic(String requestTopic) {
		this.requestTopic = requestTopic;
	}

	public String getRequestItem() {
		return requestItem;
	}

	public void setRequestItem(String requestItem) {
		this.requestItem = requestItem;
	}

	public String getRequestdescription() {
		return requestDescription;
	}

	public void setRequestdescription(String requestdescription) {
		this.requestDescription = requestdescription;
	}

	public String getRequestdepartment() {
		return requestDepartment;
	}

	public void setRequestdepartment(String requestdepartment) {
		this.requestDepartment = requestdepartment;
	}

	public boolean isRequestEnded() {
		return requestEnded;
	}

	public void setRequestEnded(boolean requestEnded) {
		this.requestEnded = requestEnded;
	}

	public String getClientRoom() {
		return clientRoom;
	}

	public void setClientRoom(String clientRoom) {
		this.clientRoom = clientRoom;
	}

	public int getRequestId() {
		return requestId;
	}
	
	public String getRequestTime() {
        return requestTime;
    }
	
	public void setRequestDate(String date) {
        this.requestTime = date;
    }
	

}
