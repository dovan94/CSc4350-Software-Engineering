package com.ibooku.kickoff;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer user_id;
	private String username;
	private String email;
	private String password;
	private String first_name;
	private String last_name;
	
	public User() {
		user_id = null;
		username = "";
		email = "";
		password = "";
		setFirst_name("");
		setLast_name("");
	}
	//user_id's getter and setter
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer id) {
		user_id = id;
	}

	// Username's getter and setter
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	// Email's getter and setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Password's getter and setter
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// first_name's getter and setter
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	// last_name's getter and setter
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
}