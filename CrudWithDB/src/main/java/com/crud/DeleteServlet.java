package com.crud;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteUserServlet")
public class DeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		int id = Integer.parseInt(request.getParameter("id"));
		
		EditDAO dao = new EditDAO();
		dao.deleteUser(id);
		
		response.sendRedirect("UsersListServlet");
	}

}
