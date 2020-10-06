package com.nt.service;

import java.util.List;

import com.nt.dto.Employeedto;

public interface EmployeeMgmtService {
	
public List<Employeedto>FetchEmpsbyDesg(String desg1,String desg2,String desg3) throws Exception; 
}
