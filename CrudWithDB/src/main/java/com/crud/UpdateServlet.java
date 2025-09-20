package com.crud;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int id = Integer.parseInt(request.getParameter("id"));
		
		User user = new User(id,name,email,password);
		EditDAO dao = new EditDAO();
		dao.updateUser(user);
		
		response.sendRedirect("UsersListServlet");
	}
}
