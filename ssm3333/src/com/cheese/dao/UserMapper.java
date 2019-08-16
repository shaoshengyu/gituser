package com.cheese.dao;

import java.util.List;

import java.util.Map;

import com.cheese.pojo.Department;
import com.cheese.pojo.PageBean;
import com.cheese.pojo.User;



public interface UserMapper {

   public int insert(User user);
   
   public User selectUser(User user);
   
   public User selectO(String userName);
  
   public int selectCount();
  
   public List<User> findByPage(Map<String,Object> map);
	
   public List<Department> selectDept(int departmentId);

}