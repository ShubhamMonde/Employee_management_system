//model class file
package com.employee.com;

public class EmployeeDetails {
		private int id;
		private String name;
		private int age;
		private String department;
		private double salary;

		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "EmployeeDetails [id=" + id + ", name=" + name + ", age=" + age + ", department=" + department
					+ ", salary=" + salary + "]";
		}

}
class EmployeeAttend{
	private String date;
	private String checkIn;
	private String checkOut;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	@Override
	public String toString() {
		return "EmployeeAttend [date=" + date + ", checkIn=" + checkIn + ", checkOut=" + checkOut + "]";
	}
}

