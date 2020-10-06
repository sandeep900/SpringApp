package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBo;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
@Repository("empdao")
public class EmployeedaoImpl implements EmployeeDao {
	//
	private static final String GET_EMPS_BY_DESGS = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP6 WHERE JOB IN(?,?,?) ORDER BY JOB";

	@Autowired
	@Qualifier("hkds")
	private DataSource ds;

	/*
	 * public EmployeedaoImpl(DataSource con) { this.con = con; }
	 */
	 Connection con =null;
	PreparedStatement ps = null;
	ResultSet rs;
	List<EmployeeBo> listbo;
	EmployeeBo bo;

	/*
	 * public Connection getConnection() {
	 * 
	 * try { Class.forName("oracle.jdbc.driver.OracleDriver");
	 * con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
	 * "system","system123"); } catch (Exception e) { e.printStackTrace();
	 * 
	 * }
	 * 
	 * 
	 * return con; }
	 */
	@Override
	public List<EmployeeBo> getempsBydesg(String desg1, String desg2, String desg3) throws Exception {

		try {
			/*
			 * con =
			 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system",
			 * "system123");
			 */
			con=ds.getConnection();
			System.out.println(con.getClass());
			ps = con.prepareStatement(GET_EMPS_BY_DESGS);
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			rs = ps.executeQuery();
			listbo = new ArrayList<EmployeeBo>();

			while (rs.next()) {
				bo = new EmployeeBo();

				bo.setEmpno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				bo.setDeptno(rs.getString(5));

				// BeanUtils.copyProperties(rs, bo);//not working nedds to be same type

				listbo.add(bo);
			}

			/*
			 * for(EmployeeBo bo: listbo) {
			 * System.out.println(bo.getDeptno()+"\t"+bo.getEmpno()+"\t"+bo.getJob()+"\t"+bo
			 * .getSal()); }
			 */
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception se) {
			se.printStackTrace();
			throw se;
		}

		finally {
			// close jdbc objs
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
				throw se; // exeception rethrowing
			}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
				throw se; // exeception rethrowing
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
				throw se; // exeception rethrowing
			}
		}
		/*
		 * rs.close(); ps.close(); con.close()
		 */;
		return listbo;
	}

}
