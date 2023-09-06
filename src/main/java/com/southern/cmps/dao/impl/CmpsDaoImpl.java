package com.southern.cmps.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.southern.cmps.dao.CmpsDao;
import com.southern.cmps.domain.Concentration;
import com.southern.cmps.domain.Student;

public class CmpsDaoImpl implements CmpsDao{
	
	@Autowired
	private JdbcTemplate cmpsDaoTemplate;

	@Override
	public Student getStudentDetail() {
		
		return null;
	}

	@Override
	public Concentration getConcentrations() {
		cmpsDaoTemplate.query("SELECT ConcentrationCode,Name FROM cmps.tbl_concentration", new ResultSetExtractor<List<Concentration>>() {

			@Override
			public List<Concentration> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Concentration> concentrations = new ArrayList<>();
				
				while(rs.next()) {
					Concentration concentration = new Concentration();
					concentration.setConcentrationCode(rs.getInt("ConcentrationCode"));
					concentration.setCourses(null);
					concentrations.add(concentration);
				}
				return concentrations;
			}
		});
		return null;
	}
	

}
