package com.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.hospital.dao.SpecialistDao;
import com.hospital.entity.User;
@WebServlet("/addSpecialist")
public class AddSpecialist extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String specName=req.getParameter("specName");
		
		SpecialistDao dao=new SpecialistDao(DBConnect.getConnection());
		
		boolean f=dao.addSpecialist(specName);
		
         HttpSession session=req.getSession();
		
		if(f) {
			session.setAttribute("succMsg","Specialist added");
			resp.sendRedirect("admin/index.jsp");
		}else {
			session.setAttribute("errorMsg", "something wromg on server");
			resp.sendRedirect("admin_login.jsp");
		}
		
	}

}
