package com.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.hospital.dao.DoctorDao;
import com.hospital.entity.Doctor;
@WebServlet("/updateDoctor")
public class UpdateDoctor extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullName=req.getParameter("fullname");
		String dob = req.getParameter("dob");
		String qualification = req.getParameter("qualification");
		String spec = req.getParameter("spec");
		String email = req.getParameter("email");
		String mobno = req.getParameter("mobno");
		String pass=req.getParameter("password");
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		Doctor doctor=new Doctor(id,fullName, dob, qualification, spec, email, mobno, pass);
		
		DoctorDao dao=new DoctorDao(DBConnect.getConnection());
		
		HttpSession session=req.getSession();
		
		if(dao.updateDoctor(doctor)) {
			session.setAttribute("succMsg", "Doctor update sucessfully..");
			resp.sendRedirect("admin/view_doctor.jsp");
			
		}else {
			session.setAttribute("errorMsg", "Something wron server");
			resp.sendRedirect("admin/view_doctor.jsp");
		}
	}

}
