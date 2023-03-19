package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.entity.Specalist;

public class SpecialistDao {
	
	private Connection con;

	public SpecialistDao(Connection con) {
		super();
		this.con = con;
	}
	public boolean addSpecialist(String spec) {
		
		boolean f=false;
		String insert=" insert into specialist(spec_name) values(?)";
		try {
			PreparedStatement ps=con.prepareStatement(insert);
			ps.setString(1, spec);
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return f;	
	}
	
	public List<Specalist> getAllSpecalists(){
		List<Specalist> list=new ArrayList<Specalist>();
		Specalist s=null;
		String query="select * from specialist";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				s=new Specalist();
				s.setId(rs.getInt(1));
				s.setSpecialistName(rs.getString(2));
				list.add(s);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return list;
	}

}
