package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hospital.entity.User;

public class UserDao {
	
	private Connection con;
	
	

	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	public boolean userRegister(User user) {
		boolean f=false;
		
		String insert="insert into user_details(full_namel,email,password) values(?,?,?)";
		 try {
			 
			PreparedStatement ps=con.prepareStatement(insert);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			
			int r=ps.executeUpdate();
			
			if(r==1) {
				f=true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return f;
		
	}
    public User userLogin(String email,String pass) {
		
    	User user=null;
		
		String select = "select * From user_details Where email=? and password=?";
		try {
			PreparedStatement ps=con.prepareStatement(select);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				user=new User(select, email, pass);
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setEmail(rs.getString(4));
			}	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Login successfully");
		return user;
	}
    
    public boolean checkOldPassword(int userid, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from user_details where id=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, oldPassword);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean changePassword(int userid, String newPassword) {
		boolean f = false;

		try {
			String sql = "update user_details set password=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

}
