package com.revature.service;

import com.revature.model.User;

public interface LoginService {

	User attemptAuthentication(String username, String password);
}
