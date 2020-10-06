package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBo;

public interface EmployeeDao {
	 List<EmployeeBo> getempsBydesg(String desg1,String desg2,String desg3) throws Exception;

}
