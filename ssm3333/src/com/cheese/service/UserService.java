package com.cheese.service;

import java.util.List;

import com.cheese.pojo.Department;
import com.cheese.pojo.PageBean;
import com.cheese.pojo.User;

public interface UserService {


	   public int insert(User user);
	   
	   public User selectUser(User user);
	   
	   public User selectO(String userName);
	   
	   public int selectCount();
	   
	   public PageBean<User> findByPage(int currentPage);
	   
	   public List<Department> selectDept(int departmentId);

}
