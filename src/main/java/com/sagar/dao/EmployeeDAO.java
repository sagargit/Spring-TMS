package com.sagar.dao;

import java.util.List;

import javax.sql.DataSource;

import com.sagar.domain.Employee;
import com.sagar.domain.PostEnum;

public interface EmployeeDAO {
	public void setDataSource(DataSource dataSource);
	public void insert(Employee e);
	public List<Employee> searchEmployee(Employee e);

	public void deleteEmployee(int employeeId);

	public void updateEmployee(Employee employee);

	public Employee searchEmployeeById(int employeeId);

	public List<Employee> searchEmployeeByPost(PostEnum post);

	public List<Employee> searchAllEmployee();

	public int row_count();
	
}
