package com.montran.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.montran.pojo.Employee;

public class EmployeeDatabaseUtil {
	private List<Employee> employeeList=new ArrayList<>();
	String sql="";
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Connection connection=null;
	public EmployeeDatabaseUtil(Connection connection) {
		this.connection = connection;

	}
	
	public boolean addNewEmployee(Employee employee) throws SQLException {
		if(employeeList.add(employee)) {
			sql="insert into employee_master values(?,?,?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setDouble(3, employee.getSalary());
			
			preparedStatement.executeUpdate();
			return true;
		}
			
		else
			return false;
	}
	
	public boolean addAllEmployees(Employee[] employee) throws SQLException {
		
		for (Employee employee2 : employee) {
			addNewEmployee(employee2);
		}
		return true;
	}
	
	public boolean updateEmployeeSalary(int employeeId ,  double newSalary) throws SQLException {
		sql="select * from employee_master";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			if(resultSet.getInt("employee_id")==employeeId) {
				sql="update employee_master set salary=? where employee_id=?";
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setDouble(1, newSalary);
				preparedStatement.setInt(2, employeeId);
				preparedStatement.executeUpdate();
				return true;
			}
		}
		
		return false;
	}
	
	public boolean deleteEmployee(int employeeId) throws SQLException {
		sql="select * from employee_master";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			if(resultSet.getInt("employee_id")==employeeId) {
				sql="delete from employee_master where employee_id=?";
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setInt(1, employeeId);
				preparedStatement.executeUpdate();
				return true;
			}
		}
		return false;
	}
	
	public boolean getEmployeeByEmployeeId(int employeeId) throws SQLException {
		sql="select * from employee_master";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			if(resultSet.getInt("employee_id")==employeeId) {
				System.out.println(resultSet.getString("employee_id")+"  "+resultSet.getString("name")+"  "+resultSet.getDouble("salary"));
				return true;
			}
		}
		return false;
	}
	
	public EmployeeDatabaseUtil() {
		// TODO Auto-generated constructor stub
	}

	public ResultSet getAllEmployees() throws SQLException{
		
		sql="select * from employee_master";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		
		return resultSet;
	}
}