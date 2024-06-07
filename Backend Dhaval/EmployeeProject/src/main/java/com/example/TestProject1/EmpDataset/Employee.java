	package com.example.TestProject1.EmpDataset;
	
	public class Employee {
	
		
		private String empName;
		private String empId;
		private String empAddress;
		private String empCity;
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Employee(String empName, String empId, String empAddress, String empCity) {
			super();
			this.empName = empName;
			this.empId = empId;
			this.empAddress = empAddress;
			this.empCity = empCity;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public String getEmpId() {
			return empId;
		}
		public void setEmpId(String empId) {
			this.empId = empId;
		}
		public String getEmpAddress() {
			return empAddress;
		}
		public void setEmpAddress(String empAddress) {
			this.empAddress = empAddress;
		}
		public String getEmpCity() {
			return empCity;
		}
		public void setEmpCity(String empCity) {
			this.empCity = empCity;
		}
		@Override
		public String toString() {
			return "Employee [empName=" + empName + ", empId=" + empId + ", empAddress=" + empAddress + ", empCity="
					+ empCity + "]";
		}
		
		
		
	}
