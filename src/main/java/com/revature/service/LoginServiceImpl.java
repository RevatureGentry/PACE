package com.revature.service;

import com.revature.data.DataSource;
import com.revature.model.User;

public class LoginServiceImpl implements LoginService {
	
	private final DataSource dataSource = DataSource.getInstance();
	
	@Override
	public User attemptAuthentication(String username, String password) {
		for (User user : dataSource.getUserTable())
			if (user.getUsername().equals(username) && getHashedPassword(user.getPassword()).equals(password))
				return user;
		return null;
	}	
	
	private String getHashedPassword(String password) {
		// invoke a Stored Procedure to perform the one-way hash of your password
		return null;
	}

}
