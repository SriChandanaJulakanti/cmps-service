package com.southern.cmps.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CmpsDao {
	
	@Autowired
	private JdbcTemplate cmpsDaoTemplate;
	
	
	public String getConcentrations() {
		return cmpsDaoTemplate.queryForObject("SELECT Name FROM cmps.tbl_concentration where ConcentrationCode = '101'", String.class);
	}
	
}
