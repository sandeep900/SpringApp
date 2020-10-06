package com.nt.dto;

import java.io.Serializable;

//import lombok.Data;

//@Data
public class Employeedto implements Serializable {
	private Integer serialno;
	private Integer empno;
	private String ename;
	private String job;
	private Float sal;
	private String deptno;

	public void setSerialno(Integer serialno) {
		this.serialno = serialno;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Float getSal() {
		return sal;
	}

	public void setSal(Float sal) {
		this.sal = sal;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Employeedto [serialno=" + serialno + ", empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal="
				+ sal + ", deptno=" + deptno + "]";
	}

	

}
