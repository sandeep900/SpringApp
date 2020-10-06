package com.nt.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBo;
import com.nt.dao.EmployeeDao;
import com.nt.dto.Employeedto;
@Service("empservice")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {

	@Autowired
	private EmployeeDao dao;
	
	
	/*
	 * public EmployeeMgmtServiceImpl(EmployeeDao dao) { this.dao = dao; }
	 */
	Employeedto dto=null;

	@Override
	public List<Employeedto> FetchEmpsbyDesg(String desg1, String desg2, String desg3) throws Exception {
		List<Employeedto> listdto;

listdto=new ArrayList<Employeedto>();

List <EmployeeBo> listbo=dao.getempsBydesg(desg1, desg2, desg3);

for(EmployeeBo bo: listbo) {
	dto=new Employeedto();
	/*
	 * dto.setEmpno(bo.getEmpno()); dto.setEname(bo.getEname());
	 * dto.setJob(bo.getJob()); dto.setSal(bo.getSal());
	 * dto.setDeptno(bo.getDeptno());
	 */

	BeanUtils.copyProperties(bo, dto);
	dto.setSerialno(listdto.size()+1);
	listdto.add(dto);


}
/*
 * for(Employeedto dto : listdto) { System.out.println("service-------------");
 * System.out.println(dto.getDeptno()+"\t"+dto.getEmpno()+"\t"+dto.getJob()+"\t"
 * +dto.getSal()); }
 */

		return listdto;
	}

}
