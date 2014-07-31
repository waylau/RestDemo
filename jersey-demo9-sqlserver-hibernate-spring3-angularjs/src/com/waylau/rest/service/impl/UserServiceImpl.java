package com.waylau.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.waylau.rest.bean.User;
import com.waylau.rest.dao.impl.UserDaoImpl;
import com.waylau.rest.service.UserService;
/**
 * User Service 接口实现
 * @author waylau.com
 * 2014-7-25
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDaoImpl;
    
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User getUserById(String id) {
		return userDaoImpl.getUserById(id);
	}

	@Override
	public boolean deleteUserById(String id) {
		return userDaoImpl.deleteUserById(id);
	}

	@Override
	public boolean createUser(User user) {
		return userDaoImpl.createUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userDaoImpl.updateUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDaoImpl.getAllUsers();
	}

}
