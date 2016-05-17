package com.sagar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.dao.EmployeeDAO;
import com.sagar.domain.Employee;
import com.sagar.domain.PostEnum;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDAO employeeDAO;
	public void saveEmployee(Employee e) {
	employeeDAO.insert(e);	
		
	}
	public List<Employee> search(Employee e) {
		
		return employeeDAO.searchEmployee(e);
	}
	public List<Employee> searchByPost(PostEnum post) {
		
		return employeeDAO.searchEmployeeByPost(post);
	}
	public void delete(int employeeId) {
		employeeDAO.deleteEmployee(employeeId);
		
	}
	public void update(Employee o) {
		
		employeeDAO.updateEmployee(o);
	}
	public Employee searchById(int employeeId) {
	
		return employeeDAO.searchEmployeeById(employeeId);
	}
	public List<Employee> findAll() {
	
		return employeeDAO.searchAllEmployee();
	}
	public int row_count() {
		
		return employeeDAO.row_count();
	}

}
