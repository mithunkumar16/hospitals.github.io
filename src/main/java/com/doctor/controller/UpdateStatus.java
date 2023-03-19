package com.doctor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.hospital.dao.AppointmentDao;
@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		int did=Integer.parseInt(req.getParameter("did"));
		String comm=req.getParameter("comm");
		
		AppointmentDao appointmentDao=new AppointmentDao(DBConnect.getConnection());
		HttpSession session=req.getSession();
		
		if(appointmentDao.UpdateCommentStatus(id, did, comm)) {
			
			session.setAttribute("succMsg", "Comment Update");
			resp.sendRedirect("doctor/patient.jsp");
			
		}else {
			session.setAttribute("errorMsg", "Something wrong on server");
			resp.sendRedirect("doctor/patient.jsp");
		}
	}

}
