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
<title>Edit Docter</title>

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

			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Doctor Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						
						<%
						int id=Integer.parseInt(request.getParameter("id"));
						DoctorDao doctorDao=new DoctorDao(DBConnect.getConnection());
						Doctor d=doctorDao.getDoctorById(id);
						
						%>


						<form action="../updateDoctor" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullname" class="form-control" value="<%=d.getFullName() %>"
									>
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									 required name="dob" value="<%=d.getDob() %>" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input required
									 name="qualification" value="<%=d.getQualification() %>"
									type="text" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Specialist</label> <select name="spec"
									required class="form-control">
									<option><%=d.getSpecialist() %></option>

									<%
									SpecialistDao dao = new SpecialistDao(DBConnect.getConnection());
									List<Specalist> list = dao.getAllSpecalists();
									for (Specalist s : list) {
									%>
									<option><%=s.getSpecialistName()%></option>
									<%
									}
									%>


								</select>
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									 required name="email" value="<%=d.getEmail() %>"
									class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text"
									 required name="mobno" value="<%=d.getMobNo() %>"
									class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									 name="password" type="text" value="<%=d.getPassword() %>"
									class="form-control">
							</div>
							<input type="hidden" name="id" value="<%=d.getId() %>" >

							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>




		</div>
	</div>
</body>
</html>