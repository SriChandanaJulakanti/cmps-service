package com.southern.cmps.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.southern.cmps.dao.CmpsDao;
import com.southern.cmps.dao.helper.ConcentrationDetailExtractor;
import com.southern.cmps.dao.helper.StudentDetailExtractor;
import com.southern.cmps.domain.Concentration;
import com.southern.cmps.domain.Student;

public class CmpsDaoImpl implements CmpsDao {
	
	@Autowired
	private JdbcTemplate cmpsDaoTemplate;
	
	private static final String GET_CONCENTRATIONS = "SELECT a.ConcentrationCode,a.Name,b.CourseId,b.CourseName FROM cmps.tbl_concentration a inner join cmps.tbl_courses b On a.ConcentrationCode = b.ConcentrationCode";
	private static final String GET_STUDENT_DETAIL = "SELECT a.UNumber,a.FirstName,a.LastName,a.Gender,a.EmailId,b.CourseId,b.Grade,b.Semester,b.Year FROM tbl_student_header a inner join tbl_student_detail b on a.UNumber = b.UNumber where a.UNumber = :uNumber";
	
	@Override
	public Student getStudentDetail() {
		return cmpsDaoTemplate.query(GET_STUDENT_DETAIL,new StudentDetailExtractor());
	}

	@Override
	public List<Concentration> getConcentrations() {
		return cmpsDaoTemplate.query(GET_CONCENTRATIONS,new ConcentrationDetailExtractor());
	}
	

}
