<%@page import="com.hospital.entity.Doctor"%>
<%@page import="com.hospital.dao.DoctorDao"%>
<%@page import="com.hospital.entity.Specalist"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.hospital.dao.SpecialistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Doctor</title>

<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container-fluid p-3">
		<div class="row">


			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Doctor Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">DOB</th>
									<th scope="col">Qualification</th>
									<th scope="col">Specialist</th>
									<th scope="col">Email</th>
									<th scope="col">Mob No</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
							<%
							DoctorDao dao2=new DoctorDao(DBConnect.getConnection());
							List<Doctor> list2=dao2.getAllDoctor();
							for(Doctor doctor:list2){%>
								<tr>
									<td><%=doctor.getFullName() %></td>
									<td><%=doctor.getDob() %></td>
									<td><%=doctor.getQualification() %></td>
									<td><%=doctor.getSpecialist() %></td>
									<td><%=doctor.getEmail() %></td>
									<td><%=doctor.getMobNo() %></td>
									<td>
									<a href="edit_doctor.jsp?id=<%=doctor.getId() %>" class="btn btn-sm btn-primary">Edit</a>
									<a href="../deleteDoctor?id=<%=doctor.getId() %>" class="btn btn-sm btn-danger">Delete</a>
									
									</td>
								</tr>
								
							<%}
							
							%>
							
							</tbody>						
						
						</table>
					</div>
				</div>
			</div>
</div>
</div>
</body>
</html>