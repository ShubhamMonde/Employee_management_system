package com.employee.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO {
	static Connection con=DBConnect.getConnection();
	public List<EmployeeDetails> getRecords(){
		List<EmployeeDetails> employees=new ArrayList<EmployeeDetails>();
		String query="select * from emp_details";
		try {
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery(query);
			while (rs.next()) {
				EmployeeDetails ed=new EmployeeDetails();
				ed.setId(rs.getInt("empId"));
				ed.setName(rs.getString("empName"));
				ed.setAge(rs.getInt("empAge"));
				ed.setDepartment(rs.getString("department"));
				ed.setSalary(rs.getDouble("empSalary"));
				employees.add(ed);
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return employees;
	}

	public boolean deleteRecord(int id) {
		String query = "delete from emp_details where empId =?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	public EmployeeDetails searchRecord(int id) {
		EmployeeDetails s = null;
		String query = "select * from emp_details where empId = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);			
			ResultSet rs = ps.executeQuery();			
			if(rs.next()) {
				s = new EmployeeDetails();
				s.setId(rs.getInt("empId"));
				s.setName(rs.getString("empName"));
				s.setAge(rs.getInt("empAge"));
				s.setDepartment(rs.getString("department"));
				s.setSalary(rs.getDouble("empSalary"));
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}		
		return s;
	}
	public boolean updateRecord(EmployeeDetails s) {
		String query = "update emp_details set empName=?, empAge=?, department=?, empSalary=? where empId=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setInt(2, s.getAge());
			ps.setString(3, s.getDepartment());
			ps.setDouble(4, s.getSalary());
			ps.setInt(5, s.getId());
			
			int i = ps.executeUpdate();
			
			if(i>0)
				return true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	public List<EmployeeAttend> getAttendanceRecords(){
		List<EmployeeAttend> employe=new ArrayList<EmployeeAttend>();
		String query="select * from empattend";
		try {
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery(query);
			while (rs.next()) {
				EmployeeAttend ea=new EmployeeAttend();
				//ea.setId(rs.getInt("empId"));
				ea.setDate(rs.getString("date"));
				ea.setCheckIn(rs.getString("checkIn"));
				ea.setCheckOut(rs.getString("checkOut"));
				employe.add(ea);
				
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return employe;
	}
	public boolean insertRecord(String name,int age,String department,double salary) {
		String query="Insert into emp_details(empName,empAge,department,empSalary) values(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, department);
			ps.setDouble(4, salary);
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
//	public void EmpIN() {
//		LocalTime inTime = LocalTime.now();
//		System.out.println(inTime);
//	public boolean empEntry(String date,String checkIn,String checkOut) {
//			String query="Insert into empattend(date,checkIn,checkOut) values(?,?,?)";
//			try {
//				PreparedStatement ps=con.prepareStatement(query);
//				ps.setString(1, date);
//				ps.setString(2, checkIn);
//				ps.setString(3, checkOut);
//				int i=ps.executeUpdate();
//				if(i>0)
//					return true;
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//			return false;
//	}

	public boolean checkIn(EmployeeDetails st1) {
		int eID = st1.getId();
		String sql = "insert into empattend (empId,date,checkIn) values(?,CURRENT_DATE(),NOW())";	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, eID);
			
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return false;
	}
	public boolean checkOut(EmployeeDetails st2) {
		int eID = st2.getId();
		String sql = "insert into empattend (empId,date,checkOut) values(?,CURRENT_DATE(),NOW())";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, eID);
			
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return false;
	}
}


