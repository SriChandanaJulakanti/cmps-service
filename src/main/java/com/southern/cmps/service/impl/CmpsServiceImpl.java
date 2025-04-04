package com.southern.cmps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.southern.cmps.dao.CmpsDao;
import com.southern.cmps.domain.Concentration;
import com.southern.cmps.domain.Student;
import com.southern.cmps.service.CmpsService;
import com.southern.cmps.service.exception.CmpsException;
import com.southern.cmps.util.UtilValidate;

@Service
public class CmpsServiceImpl implements CmpsService{
	
	@Autowired
	private CmpsDao cmpsDaoImpl;
	
	@Override
	public Student getStudentDetail(String uNumber) throws CmpsException {
		if(UtilValidate.isEmpty(uNumber)) {
			throw new CmpsException("Invalid UNumber");
		}
		Student student = cmpsDaoImpl.getStudentDetail(uNumber);
		if(UtilValidate.isEmpty(student)) {
			throw new CmpsException("Invalid Student Information");
		}
		return student;
	}
	
	@Override
	public List<Concentration> getConcentrations() throws CmpsException {
		List<Concentration> concentrations = cmpsDaoImpl.getConcentrations();
		if (UtilValidate.isEmpty(concentrations)) {
			throw new CmpsException("Invalid Concentrations");
		}
		return concentrations;
	}

}
