package com.southern.cmps.dao.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.southern.cmps.domain.Concentration;
import com.southern.cmps.domain.Course;

public class ConcentrationDetailExtractor implements ResultSetExtractor<List<Concentration>>{

	@Override
	public List<Concentration> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Concentration> concentrationsMap = new HashMap<>();
		
		while(rs.next()) {
			int concentrationCode = rs.getInt("ConcentrationCode");
			if(!concentrationsMap.containsKey(concentrationCode)) {
				Concentration concentration = new Concentration();
				concentration.setConcentrationCode(concentrationCode);
				concentration.setName(rs.getString("Name"));
				concentration.setCourses(new ArrayList<Course>());
				concentrationsMap.put(concentrationCode, concentration);
			}
			setCourses(concentrationsMap, rs);
		}
		return (List<Concentration>) concentrationsMap.values();
	}
	
	private void setCourses(Map<Integer, Concentration> concentrationsMap, ResultSet rs) throws SQLException {
		int concentrationCode = rs.getInt("ConcentrationCode");
		Course course = new Course();
		course.setCourseId(rs.getString("CourseId"));
		course.setCourseName(rs.getString("CourseName"));
		course.setConcentrationCode(concentrationCode);
		course.setHours(rs.getInt("Hours"));
		concentrationsMap.get(concentrationCode).getCourses().add(course);
	}

}
