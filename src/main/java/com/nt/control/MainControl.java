package com.nt.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.nt.dto.Employeedto;
import com.nt.service.EmployeeMgmtService;
@Controller("control")
//@Lazy
public class MainControl {
	
	@Autowired
	private EmployeeMgmtService service;

	/*
	 * public MainControl(EmployeeMgmtService service) { this.service = service; }
	 */

	
	public List<Employeedto>gatherEmpsbyDesg(String desg1,String desg2,String desg3)throws Exception
			{
		
		
		List<Employeedto> listdto = null;
			
		
		 listdto=service.FetchEmpsbyDesg(desg1, desg2, desg3);
				
		
		return listdto;
	}
	
	

}
