package com.arthur.hr.front.batch.employees;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeDTOMapper implements RowMapper<EmployeeDTO> {  
	   
	   @Override 
	   public EmployeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException { 
		  EmployeeDTO employee = new EmployeeDTO();  
		  employee.setFirstName(rs.getString("FIRST_NAME"));
		  employee.setLastName(rs.getString("LAST_NAME"));
		  employee.setEmail(rs.getString("EMAIL"));
	      return employee; 
	   } 
	   
}
