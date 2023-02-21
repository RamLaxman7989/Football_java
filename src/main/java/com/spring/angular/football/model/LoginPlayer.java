package com.spring.angular.football.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class LoginPlayer {
	
	@Id
	private Long id;
	private String username;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginPlayer(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginPlayer [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
}
