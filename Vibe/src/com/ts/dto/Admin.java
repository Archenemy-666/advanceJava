package com.ts.dto;

public class Admin {
	private int adminId ;
	private String name ;
	private String loginId ;
	private String password;
	private String dept ;
	
	
	public Admin() {}


	public Admin(int adminId, String name, String loginId, String password, String dept) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.loginId = loginId;
		this.password = password;
		this.dept = dept;
	}


	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", loginId=" + loginId + ", password=" + password
				+ ", dept=" + dept + "]";
	}
	

}

