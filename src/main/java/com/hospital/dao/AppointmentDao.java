package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.entity.Appointment;

public class AppointmentDao {

	private Connection con;

	public AppointmentDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean addAppointment(Appointment appointment) {
		boolean f = false;

		String query = "insert into appointment(user_id, fullname, gender, age, appoint_date, email, phone, diseases, doctor_id, address, status) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, appointment.getUserId());
			ps.setString(2, appointment.getFullName());
			ps.setString(3, appointment.getGender());
			ps.setString(4, appointment.getAge());
			ps.setString(5, appointment.getAppoinDate());
			ps.setString(6, appointment.getEmail());
			ps.setString(7, appointment.getPhNo());
			ps.setString(8, appointment.getDiseases());
			ps.setInt(9, appointment.getDoctorId());
			ps.setString(10, appointment.getAddress());
			ps.setString(11, appointment.getStatus());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return f;
	}

	public List<Appointment> getAllAppointmentByIdLoginUser(int userId) {

		List<Appointment> list = new ArrayList<Appointment>();

		Appointment appointment = null;

		String quary = "select * from appointment where user_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(quary);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				appointment = new Appointment();
				appointment.setId(rs.getInt(1));
				appointment.setUserId(rs.getInt(2));
				appointment.setFullName(rs.getString(3));
				appointment.setGender(rs.getString(4));
				appointment.setAge(rs.getString(5));
				appointment.setAppoinDate(rs.getString(6));
				appointment.setEmail(rs.getString(7));
				appointment.setPhNo(rs.getString(8));
				appointment.setDiseases(rs.getString(9));
				appointment.setDoctorId(rs.getInt(10));
				appointment.setAddress(rs.getString(11));
				appointment.setStatus(rs.getString(12));
				list.add(appointment);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	public List<Appointment> getAllAppointmentByDoctorLogin(int doctorId) {

		List<Appointment> list = new ArrayList<Appointment>();

		Appointment appointment = null;

		String quary = "select * from appointment where doctor_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(quary);
			ps.setInt(1, doctorId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				appointment = new Appointment();
				appointment.setId(rs.getInt(1));
				appointment.setUserId(rs.getInt(2));
				appointment.setFullName(rs.getString(3));
				appointment.setGender(rs.getString(4));
				appointment.setAge(rs.getString(5));
				appointment.setAppoinDate(rs.getString(6));
				appointment.setEmail(rs.getString(7));
				appointment.setPhNo(rs.getString(8));
				appointment.setDiseases(rs.getString(9));
				appointment.setDoctorId(rs.getInt(10));
				appointment.setAddress(rs.getString(11));
				appointment.setStatus(rs.getString(12));
				list.add(appointment);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	public Appointment getAllAppointmentById(int id) {

		Appointment appointment = null;

		String quary = "select * from appointment where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(quary);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				appointment = new Appointment();
				appointment.setId(rs.getInt(1));
				appointment.setUserId(rs.getInt(2));
				appointment.setFullName(rs.getString(3));
				appointment.setGender(rs.getString(4));
				appointment.setAge(rs.getString(5));
				appointment.setAppoinDate(rs.getString(6));
				appointment.setEmail(rs.getString(7));
				appointment.setPhNo(rs.getString(8));
				appointment.setDiseases(rs.getString(9));
				appointment.setDoctorId(rs.getInt(10));
				appointment.setAddress(rs.getString(11));
				appointment.setStatus(rs.getString(12));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return appointment;
	}

	public boolean UpdateCommentStatus(int id, int doctId, String comm) {
		boolean f = false;

		String query = "update appointment set status=? where id=? and doctor_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, comm);
			ps.setInt(2, id);
			ps.setInt(3, doctId);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return f;
	}

	public List<Appointment> getAllAppointment() {

		List<Appointment> list = new ArrayList<Appointment>();

		Appointment appointment = null;

		String quary = "select * from appointment order by id desc";
		try {
			PreparedStatement ps = con.prepareStatement(quary);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				appointment = new Appointment();
				appointment.setId(rs.getInt(1));
				appointment.setUserId(rs.getInt(2));
				appointment.setFullName(rs.getString(3));
				appointment.setGender(rs.getString(4));
				appointment.setAge(rs.getString(5));
				appointment.setAppoinDate(rs.getString(6));
				appointment.setEmail(rs.getString(7));
				appointment.setPhNo(rs.getString(8));
				appointment.setDiseases(rs.getString(9));
				appointment.setDoctorId(rs.getInt(10));
				appointment.setAddress(rs.getString(11));
				appointment.setStatus(rs.getString(12));
				list.add(appointment);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}
}
