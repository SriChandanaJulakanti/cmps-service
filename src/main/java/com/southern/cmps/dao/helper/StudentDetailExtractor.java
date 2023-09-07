package com.southern.cmps.dao.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.southern.cmps.domain.CourseDetail;
import com.southern.cmps.domain.Student;

public class StudentDetailExtractor implements ResultSetExtractor<Student> {

	@Override
	public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, Student> studentsMap = new HashMap<>();
		while(rs.next()) {
			String uNumber = rs.getString("UNumber");
			if(!studentsMap.containsKey(uNumber)) {
				Student student = new Student();
				student.setUNumber(uNumber);
				student.setFirstName(rs.getString("FirstName"));
				student.setLastName(rs.getString("LastName"));
				student.setGender(rs.getString("Gender"));
				student.setEmailId(rs.getString("EmailId"));
				student.setCourses(new ArrayList<CourseDetail>());
			}
			setCourseDetail(studentsMap,rs);
		}
		return (Student) studentsMap.values();
	}
	
	private void setCourseDetail(Map<String, Student> studentsMap, ResultSet rs) throws SQLException {
		String uNumber = rs.getString("UNumber");
		CourseDetail courseDetail = new CourseDetail();
		courseDetail.setCourseId(rs.getString("CourseId"));
		courseDetail.setGrade(rs.getString("Grade"));
		courseDetail.setSemester(rs.getString("Semester"));
		courseDetail.setYear(rs.getDate("Year"));
		studentsMap.get(uNumber).getCourses().add(courseDetail);
	}

}
