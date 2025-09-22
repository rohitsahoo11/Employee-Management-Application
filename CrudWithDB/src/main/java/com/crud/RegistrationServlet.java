package com.crud;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			
			
			Properties pro = new Properties();
			InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
			pro.load(input);
			
			String url = System.getenv("db_url");
			String userName = System.getenv("db_username");
			String pwd = System.getenv("db_password");
			String driver = pro.getProperty("db.driver");
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,userName,pwd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO USERS (NAME, EMAIL, PASSWORD) VALUES (?, ?, ?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			int row = ps.executeUpdate();
			
			if(row>0) {
				request.setAttribute("name", name);
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}
			else {
				response.getWriter().println("Error in registration!");
			}
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
				e.printStackTrace();
		}
	}

}
