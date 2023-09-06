package com.southern.cmps.dao;

import com.southern.cmps.domain.Concentration;
import com.southern.cmps.domain.Student;

public interface CmpsDao {
	
	public Student getStudentDetail();
	
	public Concentration getConcentrations();
	
//	public Student getStudentDetail() {
////		return cmpsDaoTemplate.query("SELECT Name FROM cmps.tbl_concentration where ConcentrationCode = '101'", String.class);
//		return null;
//	}   
	
	
}
