package com.crud;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			
			
			Properties pro = new Properties();
			InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
			pro.load(input);
			
			String url = pro.getProperty("db.url");
			String userName = pro.getProperty("db.username");
			String pwd = pro.getProperty("db.password");
			String driver = pro.getProperty("db.driver");
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,userName,pwd);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE EMAIL=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				String dbPassword = rs.getString("PASSWORD");
				String name = rs.getString("NAME");
				
				if(dbPassword.equals(password)) {
					request.setAttribute("name", name);
					RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
					rd.forward(request, response);
					
				}
				else {
					request.setAttribute("errorMessage", "Invalid email or password.");
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
				}
			}
			else {
				request.setAttribute("errorMessage", "Invalid email or password.");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
			}
			
			rs.close();
			ps.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
