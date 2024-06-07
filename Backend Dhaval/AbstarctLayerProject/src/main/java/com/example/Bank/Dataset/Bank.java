package com.example.Bank.Dataset;

public class Bank {
	
	private String ac;
	private String name;
	private String Branch;
	public Bank() {
		super();
	}
	public Bank(String ac, String name, String branch) {
		super();
		this.ac = ac;
		this.name = name;
		Branch = branch;
	}
	public String getAc() {
		return ac;
	}
	public void setAc(String ac) {
		this.ac = ac;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	@Override
	public String toString() {
		return "Bank [ac=" + ac + ", name=" + name + ", Branch=" + Branch + "]";
	}
	
	

}
