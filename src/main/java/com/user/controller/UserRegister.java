package com.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.hospital.dao.UserDao;
import com.hospital.entity.User;
import com.hospital.service.UserService;
@WebServlet("/userRegister")
public class UserRegister extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("fullname");
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(pass);
		
		User user=new User(name, email, pass);

		UserDao dao=new UserDao(DBConnect.getConnection());
		HttpSession session=req.getSession();
		
		boolean f=dao.userRegister(user);
		
		if(f) { 
			
			session.setAttribute("sucMsg", "Register sucessfully.");
			resp.sendRedirect("signup.jsp");
			System.out.println("Register sucessfully..");
//			RequestDispatcher dispatcher=req.getRequestDispatcher("signup.jsp");
//			dispatcher.include(req, resp);
		}else {
			System.out.println("data not inserted..");
			session.setAttribute("errorMsg", "Invalid !");
			resp.sendRedirect("signup.jsp");
//			RequestDispatcher dispatcher=req.getRequestDispatcher("signup.jsp");
//			dispatcher.include(req, resp);
		}
	}
	
	
	

}
