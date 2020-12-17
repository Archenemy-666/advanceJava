package com.ts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ts.db.MyConnection;
import com.ts.dto.Employee;

public class EmployeeDAO {
	public Employee getEmployee(String loginId,String password) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String SELECT = "select * from employee where loginId = ? and password = ?";
		try {
			con = MyConnection.getConnection();
			pst = con.prepareStatement(SELECT);
			pst.setString(1, loginId);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()){
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employee.setLoginId(rs.getString(4));
				employee.setPassword(rs.getString(5)); 
				return employee;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public int register(Employee employee) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String INSERT = "insert into employee values(?,?,?,?,?)";
		try {
			con = MyConnection.getConnection();
			pst = con.prepareStatement(INSERT);
			pst.setInt(1, employee.getEmpId());
			pst.setString(2, employee.getEmpName());
			pst.setDouble(3, employee.getSalary());
			pst.setString(4, employee.getLoginId());
			pst.setString(5, employee.getPassword());
			
			int x = pst.executeUpdate();
			if(x > 0){
				return x;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public Employee getEmployee(int empId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String SELECT = "select * from employee where empId = ?;";
		try {
			con = MyConnection.getConnection();
			pst = con.prepareStatement(SELECT);
			pst.setInt(1, empId);
			rs = pst.executeQuery();
			if(rs.next()){
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employee.setLoginId(rs.getString(4));
				employee.setPassword(rs.getString(5)); 
				return employee;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<Employee> getEmployees() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String SELECT = "select * from employee;";
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			con = MyConnection.getConnection();
			pst = con.prepareStatement(SELECT);
			rs = pst.executeQuery();
			while(rs.next()){			
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employee.setLoginId(rs.getString(4));
				employee.setPassword(rs.getString(5)); 
				employeeList.add(employee);
				
				
			}
			return employeeList ;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public Employee getEmployee(String loginId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String SELECT = "select * from employee where loginId = ?";
		try {
			con = MyConnection.getConnection();
			pst = con.prepareStatement(SELECT);
			pst.setString(1, loginId);
			
			rs = pst.executeQuery();
			if(rs.next()){
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employee.setLoginId(rs.getString(4));
				employee.setPassword(rs.getString(5)); 
				return employee;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
