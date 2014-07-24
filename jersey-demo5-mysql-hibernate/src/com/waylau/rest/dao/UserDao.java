package com.waylau.rest.dao;

import java.util.List;

import com.waylau.rest.bean.User;
 

/**
 * User Dao 接口
 * @author waylau.com
 * 2014-3-18
 */
public interface UserDao {
	
	public User getUserById(String id);

	public boolean deleteUserById(String id);

	public boolean createUser(User user);

	public boolean updateUser(User user);

	public List<User> getAllUsers();
}
