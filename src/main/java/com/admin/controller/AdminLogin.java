package com.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.entity.User;
@WebServlet("/adminLogin")
public class AdminLogin  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		HttpSession session=req.getSession();
		
		if("admin@gmail.com".equals(email) && "admin".equals(pass)) {
			session.setAttribute("adminObj",new User(pass, email, pass));
			resp.sendRedirect("admin/index.jsp");
		}else {
			session.setAttribute("errorMsg", "Invalid email & password");
			resp.sendRedirect("admin_login.jsp");
		}
	}

}
