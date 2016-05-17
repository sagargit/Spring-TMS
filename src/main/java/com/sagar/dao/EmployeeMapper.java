package com.sagar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sagar.domain.Employee;
import com.sagar.domain.PostEnum;

public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet res, int arg1) throws SQLException {
		Employee e1 = new Employee();
		e1.setEmployeeId(res.getInt(1));
		e1.setEmployeeName(res.getString(2));
		e1.setPost(PostEnum.getPostEnum(res.getInt(3)));
		e1.setEmail(res.getString(4));
		e1.setPassword(res.getString(5));
		return e1;
	}

}
