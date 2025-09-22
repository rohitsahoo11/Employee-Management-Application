package com.crud;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class EditDAO {
	public static  User getId(int id) {
		User u = null;
		try{
			
			
			
			Properties pro = new Properties();
			InputStream input = EditDAO.class.getClassLoader().getResourceAsStream("config.properties");
			pro.load(input);
			
			String url = System.getenv("db_url");
			String userName = System.getenv("db_username");
			String pwd = System.getenv("db_password");
			String driver = pro.getProperty("db.driver");
			
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,userName,pwd);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return u;
		
	}
	
	public void updateUser(User u) {
			try{
			
				
				
				Properties pro = new Properties();
				InputStream input = EditDAO.class.getClassLoader().getResourceAsStream("config.properties");
				pro.load(input);
				
				String url = System.getenv("db_url");
				String userName = System.getenv("db_username");
				String pwd = System.getenv("db_password");
				String driver = pro.getProperty("db.driver");
				
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url,userName,pwd);
				PreparedStatement ps = conn.prepareStatement("update users set name=?, email=?, password=? where id=?");
				ps.setString(1, u.getName());
				ps.setString(2, u.getEmail());
				ps.setString(3, u.getPassword());
				ps.setInt(4, u.getId());
				ps.executeUpdate();
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}
	
	public void deleteUser(int id) {
		
		try{
			
			
			
			Properties pro = new Properties();
			InputStream input = EditDAO.class.getClassLoader().getResourceAsStream("config.properties");
			pro.load(input);
			
			String url = System.getenv("db_url");
			String userName = System.getenv("db_username");
			String pwd = System.getenv("db_password");
			String driver = pro.getProperty("db.driver");
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,userName,pwd);
			PreparedStatement ps = conn.prepareStatement("DELETE FROM USERS WHERE ID=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}