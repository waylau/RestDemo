package com.waylau.rest.service;

import java.util.List;

import com.waylau.rest.bean.User;
 

/**
 * User Service 接口
 * @author waylau.com
 * 2014-7-25
 */
public interface UserService {
	
	public User getUserById(String id);

	public boolean deleteUserById(String id);

	public boolean createUser(User user);

	public boolean updateUser(User user);

	public List<User> getAllUsers();
}
