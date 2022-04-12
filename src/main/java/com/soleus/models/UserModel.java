package com.soleus.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name = "user")
public class UserModel implements Serializable {
	
	private static final long serialVersionUID = 2L;

	@Id
    @Column(name = "room")
	private String user;
	@Column(name = "password")
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "department")
	private String department;
	
	
	
	public UserModel() {};

	public UserModel(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	public UserModel(String user, String password, String name, String department) {
		super();
		this.user = user;
		this.password = password;
		this.name = name;
		this.department = department;
	}
	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "UserModel [user=" + user + ", password=" + password + ", name=" + name + ", department=" + department
				+ "]";
	}


	

}
