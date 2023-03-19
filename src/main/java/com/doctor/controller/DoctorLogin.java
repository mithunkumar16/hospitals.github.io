package com.doctor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.hospital.dao.DoctorDao;
import com.hospital.dao.UserDao;
import com.hospital.entity.Doctor;
import com.hospital.entity.User;
@WebServlet("/doctorLogin")
public class DoctorLogin extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		HttpSession session=req.getSession();
		DoctorDao dao=new DoctorDao(DBConnect.getConnection());
		Doctor doctor =dao.login(email, pass);
		
		if(doctor!=null) {
			session.setAttribute("doctObj", doctor);
			resp.sendRedirect("doctor/index.jsp");
		}else {
			session.setAttribute("errorMsg", "Invalid email & password");
			resp.sendRedirect("doctor_login.jsp");
		}
	}

}
