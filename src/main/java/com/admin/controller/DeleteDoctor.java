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
@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		DoctorDao dao = new DoctorDao(DBConnect.getConnection());

		HttpSession session = req.getSession();

		if (dao.deleteDoctor(id)) {
			session.setAttribute("succMsg", "Doctor deleted sucessfully..");
			resp.sendRedirect("admin/view_doctor.jsp");

		} else {
			session.setAttribute("errorMsg", "Something wron server");
			resp.sendRedirect("admin/view_doctor.jsp");
		}
	}

}
