package com.sagar.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sagar.domain.Employee;
import com.sagar.domain.PostEnum;

public class EmployeeJDBCTemplate implements EmployeeDAO {
	List<Employee> l1 = null;
	private JdbcTemplate jdbcTemplateObject;
	public void setDataSource(DataSource dataSource) {

		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void insert(Employee employee) {
		String sql = "insert into employee values(" + employee.getEmployeeId()
				+ ",'" + employee.getEmployeeName() + "',"
				+ employee.getPost().getValue() + ",'" + employee.getEmail()
				+ "','" + employee.getPassword() + "')";
		jdbcTemplateObject.update(sql);
	}

	public List<Employee> searchEmployee(Employee e) {

		String sql = "SELECT * FROM employee WHERE 1=1";
		boolean FLAG = false;
		if (e.getEmployeeName() != null && !e.getEmployeeName().equals("")) {
			sql += " AND employeeName='" + e.getEmployeeName() + "'";
			FLAG = true;
		}
		if (e.getEmail() != null && !e.getEmail().equals("")) {
			sql += " AND email='" + e.getEmail() + "'";
			FLAG = true;
		}
		if (e.getPost() != null) { // it works
			sql += " AND post=" + e.getPost().getValue();
			FLAG = true;
		}
		if (e.getPassword() != null && !e.getPassword().equals("")) {
			sql += " AND password='" + e.getPassword() + "'";
			FLAG = true;
		}

		if (FLAG) {

			l1 = jdbcTemplateObject.query(sql, new EmployeeMapper());

		} else {
			l1 = null; // throwing an empty list
			

		}
		return l1;

	}

	public void deleteEmployee(int employeeId) {
		String query = "DELETE FROM employee WHERE employeeId=" + employeeId;
		jdbcTemplateObject.update(query);
	}

	public void updateEmployee(Employee e) {

		String sql = "UPDATE employee SET employeeId=" + e.getEmployeeId();
		if (e.getEmployeeName() != null && !e.getEmployeeName().equals("")) {
			sql += ",employeeName='" + e.getEmployeeName() + "'";

		}
		if (e.getEmail() != null && !e.getEmail().equals("")) {
			sql += ",email='" + e.getEmail() + "'";

		}
		if (e.getPost() != null) { // it works
			sql += ",post=" + e.getPost().getValue();
		}

		if (e.getPassword() != null && !e.getPassword().equals("")) {
			sql += ",password='" + e.getPassword() + "'";
		}

		sql += " WHERE employeeId=" + e.getEmployeeId();
		jdbcTemplateObject.update(sql);
	}

	public Employee searchEmployeeById(int employeeId) {
		String sql = "SELECT * FROM employee WHERE employeeId=?";
		Employee employee=jdbcTemplateObject.queryForObject(sql,new Object[]{employeeId} ,new EmployeeMapper());
		return employee;
		
	}

	public List<Employee> searchEmployeeByPost(PostEnum postEmployee) {
		String sql = "SELECT * from employee where post=" + postEmployee.getValue();
		return jdbcTemplateObject.query(sql, new EmployeeMapper());
		
	}

	public List<Employee> searchAllEmployee() {
		String sql = "SELECT * FROM employee";
		return jdbcTemplateObject.query(sql, new EmployeeMapper());
	}

	@SuppressWarnings("deprecation")
	public int row_count() {
		String sql = "SELECT COUNT(*) FROM employee";
		return jdbcTemplateObject.queryForInt(sql);
		
	}


}
