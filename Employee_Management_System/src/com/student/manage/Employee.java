package com.student.manage;

public class Employee {
		
		private int employeeId;
		private String employeeName;
		private int employeePhone;
		private double employeeSalary;
		
		public int getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}

		public String getEmployeeName() {
			return employeeName;
		}

		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}

		public int getEmployeePhone() {
			return employeePhone;
		}

		public void setEmployeePhone(int employeePhone) {
			this.employeePhone = employeePhone;
		}

		public double getEmployeeSalary() {
			return employeeSalary;
		}

		public void setEmployeeSalary(double employeeSalary) {
			this.employeeSalary = employeeSalary;
		}

		public Employee(int employeeId, String employeeName, int employeePhone, double employeeSalary) {
			super();
			this.employeeId = employeeId;
			this.employeeName = employeeName;
			this.employeePhone = employeePhone;
			this.employeeSalary = employeeSalary;
		}

		public Employee(String employeeName, int employeePhone, double employeeSalary) {
			super();
			this.employeeName = employeeName;
			this.employeePhone = employeePhone;
			this.employeeSalary = employeeSalary;
		}

		public Employee() {
			super();
		
		}

		@Override
		public String toString() {
			return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeePhone="
					+ employeePhone + ", employeeSalary=" + employeeSalary + "]";
		}

}
