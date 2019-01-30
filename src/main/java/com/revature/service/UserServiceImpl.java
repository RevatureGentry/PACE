package com.revature.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.data.DataSource;

public class UserServiceImpl implements UserService {

	private final DataSource dataSource = DataSource.getInstance();
	
	@Override
	public Object process(HttpServletRequest request, HttpServletResponse response) {
		return dataSource.getUserTable();
	}

}
