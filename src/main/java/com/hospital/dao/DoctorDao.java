package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.entity.Doctor;

public class DoctorDao {

	private Connection con;

	public DoctorDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean registerDoctor(Doctor doctor) {
		boolean f = false;

		String query = "insert into doctor(full_name,dob,qualifiction,specialist,email,mobno,password) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, doctor.getFullName());
			ps.setString(2, doctor.getDob());
			ps.setString(3, doctor.getQualification());
			ps.setString(4, doctor.getSpecialist());
			ps.setString(5, doctor.getEmail());
			ps.setString(6, doctor.getMobNo());
			ps.setString(7, doctor.getPassword());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return f;
	}

	public List<Doctor> getAllDoctor() {
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor doctor = null;
		String query = "select *from doctor order by id desc";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				doctor = new Doctor();
				doctor.setId(rs.getInt(1));
				doctor.setFullName(rs.getString(2));
				doctor.setDob(rs.getString(3));
				doctor.setQualification(rs.getString(4));
				doctor.setSpecialist(rs.getString(5));
				doctor.setEmail(rs.getString(6));
				doctor.setMobNo(rs.getString(7));
				doctor.setPassword(rs.getString(8));
				list.add(doctor);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}
//find get by id update and delete
	public Doctor getDoctorById(int id){
		
		Doctor doctor=null;
		String query="select *from doctor where id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				doctor=new Doctor();
				doctor.setId(rs.getInt(1));
				doctor.setFullName(rs.getString(2));
				doctor.setDob(rs.getString(3));
				doctor.setQualification(rs.getString(4));
				doctor.setSpecialist(rs.getString(5));
				doctor.setEmail(rs.getString(6));
				doctor.setMobNo(rs.getString(7));
				doctor.setPassword(rs.getString(8));
			}		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return doctor;
	}
	
	//doctor update
	public boolean updateDoctor(Doctor doctor) {
		boolean f = false;

		String query = "update doctor set full_name=?,dob=?,qualifiction=?,specialist=?,email=?,mobno=?,password=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, doctor.getFullName());
			ps.setString(2, doctor.getDob());
			ps.setString(3, doctor.getQualification());
			ps.setString(4, doctor.getSpecialist());
			ps.setString(5, doctor.getEmail());
			ps.setString(6, doctor.getMobNo());
			ps.setString(7, doctor.getPassword());
			ps.setInt(8, doctor.getId());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return f;
	}
	
	public boolean deleteDoctor(int id) {
		boolean f=false;
		
		String query="delete from doctor where id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;		
	}
	
	public Doctor login(String email,String pass) {
		Doctor doctor=null;
		
		String query="select * from doctor where email=? and password=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				doctor=new Doctor();
				doctor.setId(rs.getInt(1));
				doctor.setFullName(rs.getString(2));
				doctor.setDob(rs.getString(3));
				doctor.setQualification(rs.getString(4));
				doctor.setSpecialist(rs.getString(5));
				doctor.setEmail(rs.getString(6));
				doctor.setMobNo(rs.getString(7));
				doctor.setPassword(rs.getString(8));
				
			}	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return doctor;
	}
	
	
	public int countDoctor() {
		int i = 0;
		try {
			String sql = "select * from doctor";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countAppointment() {
		int i = 0;
		try {
			String sql = "select * from appointment";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countAppointmentByDocotrId(int did) {
		int i = 0;
		try {
			String sql = "select * from appointment where doctor_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countUser() {
		int i = 0;
		try {
			String sql = "select * from user_details";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countSpecialist() {
		int i = 0;
		try {
			String sql = "select * from specialist";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}
	
	public boolean checkOldPassword(int userid, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from doctor where id=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, oldPassword);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean changePassword(int userid, String newPassword) {
		boolean f = false;

		try {
			String sql = "update doctor set password=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	public boolean editDoctorProfile(Doctor doctor) {
		boolean f = false;

		String query = "update doctor set full_name=?,dob=?,qualifiction=?,specialist=?,email=?,mobno=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, doctor.getFullName());
			ps.setString(2, doctor.getDob());
			ps.setString(3, doctor.getQualification());
			ps.setString(4, doctor.getSpecialist());
			ps.setString(5, doctor.getEmail());
			ps.setString(6, doctor.getMobNo());	
			ps.setInt(7, doctor.getId());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return f;
	}
	
}
