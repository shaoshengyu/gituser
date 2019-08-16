package com.cheese.pojo;

import java.util.List;

public class Department {
	
	private int departmentId;
	
	private String departmentName;
	
	private String departmentQx;

	private List<User> userList;	
	
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentQx() {
		return departmentQx;
	}

	public void setDepartmentQx(String departmentQx) {
		this.departmentQx = departmentQx;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Department() {
		
	}

	public Department(int departmentId, String departmentName, String departmentQx, List<User> userList) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentQx = departmentQx;
		this.userList = userList;
	}
	
}
