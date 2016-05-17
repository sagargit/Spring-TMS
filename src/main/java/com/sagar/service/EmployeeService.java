package com.sagar.service;

import java.util.List;

import com.sagar.domain.Employee;
import com.sagar.domain.PostEnum;

public interface EmployeeService {
	public void saveEmployee(Employee e);

	public List<Employee> search(Employee e);

	public List<Employee> searchByPost(PostEnum post);

	public void delete(int employeeId);

	public void update(Employee o);

	public Employee searchById(int employeeId);

	public List<Employee> findAll();

	public int row_count();
}
