package com.ibooku.kickoff;

import javax.persistence.Entity;
import javax.persistence.Column;
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
		this.user_id = null;
		this.username = "";
		this.email = "";
		this.password = "";
		this.first_name = "";
		this.last_name = "";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst() {
		return first_name;
	}

	public void setFirst(String first_name) {
		this.first_name = first_name;
	}

	public String getLast() {
		return last_name;
	}

	public void setLast(String last_name) {
		this.last_name = last_name;
	}
}
