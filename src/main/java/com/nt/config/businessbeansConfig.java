package com.nt.config;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.zaxxer.hikari.HikariDataSource;



@Configuration
@ComponentScan(basePackages = { "com.nt.dao,com.nt.service"})
//@ImportResource("com/nt/cfg/businessbeans.xml")
public class businessbeansConfig {

	
	
	@Bean(name = "hkds")
	public DataSource createDS() {
		HikariDataSource hkds=null;
		
	   hkds=new HikariDataSource();
		hkds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hkds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
		hkds.setUsername("system");
		hkds.setPassword("system123");
		hkds.setMinimumIdle(10);
		hkds.setMaximumPoolSize(100);
		return hkds;
		
	
	}
	
}
