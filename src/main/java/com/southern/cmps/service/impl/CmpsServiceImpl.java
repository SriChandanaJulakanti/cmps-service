package com.southern.cmps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.southern.cmps.dao.CmpsDao;
import com.southern.cmps.domain.Student;
import com.southern.cmps.service.CmpsService;

@Service
public class CmpsServiceImpl implements CmpsService{
	
	@Autowired
	private CmpsDao cmpsDaoImpl;
	
	@Override
	public void getStudentDetail() {
		Student student = cmpsDaoImpl.getStudentDetail();
		
		
	}

}
