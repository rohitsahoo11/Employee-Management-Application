package com.crud;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/UsersListServlet")
public class UsersListServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		
		List<User> userList = new ArrayList<>();
		
		try {
			
			
			Properties pro = new Properties();
			//InputStream input = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			InputStream input = EditDAO.class.getClassLoader().getResourceAsStream("config.properties");

			pro.load(input);
			
			String url = System.getenv("db_url");
			String userName = System.getenv("db_username");
			String pwd = System.getenv("db_password");
			String driver = pro.getProperty("db.driver");
			
			Class.forName(driver);
			
			
			Connection conn = DriverManager.getConnection(url,userName,pwd);
			System.out.println("✅ Connected to DB: " + conn);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM public.users ORDER BY id");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				userList.add(u);
			}
			System.out.println(userList);
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("userList", userList);
		RequestDispatcher rd = request.getRequestDispatcher("users.jsp");
		rd.forward(request, response);
	}
}
