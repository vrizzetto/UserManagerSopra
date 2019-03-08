package com.vriz.servlet;

import java.util.ArrayList;
import java.util.List;

public class LesUsers {
	
	private List<User> _users;
	public List<User> getUsers(){
		return _users;
	}
	
	public LesUsers() {
		_users = new ArrayList<>();
	}
	
}
