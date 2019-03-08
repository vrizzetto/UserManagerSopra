package com.vriz.servlet;

public class User {
	
	private String email;
	private String mdp;
	private String id;	
	
	public User(String email, String mdp, String id) {
		this.email = email;
		this.mdp = mdp;
		this.id = id;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getMdp() {
		return this.mdp;
	}
	
	public String getId() {
		return this.id;
	}
}
