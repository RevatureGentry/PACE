package com.revature;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.User;
import com.revature.service.LoginService;
import com.revature.service.LoginServiceImpl;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private final LoginService service = new LoginServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String username = req.getParameter("username");
		final String password = req.getParameter("password");
		
		User attempting = service.attemptAuthentication(username, password);
		
		if (attempting != null) {
			req.getSession().setAttribute("firstname", attempting.getFirstname());
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
	}
}
