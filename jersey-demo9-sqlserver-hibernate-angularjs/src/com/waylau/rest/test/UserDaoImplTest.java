package com.waylau.rest.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.waylau.rest.bean.User;
import com.waylau.rest.dao.impl.UserDaoImpl;
import com.waylau.rest.service.impl.UserServiceImpl;

public class UserDaoImplTest {
 
	public UserDaoImplTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] path = { "applicationContext.xml" };
		BeanFactory factory = new ClassPathXmlApplicationContext(path);
		UserDaoImpl userDaoImpl = (UserDaoImpl) factory
		.getBean("UserDaoImpl");
		
		List<User> users = new ArrayList<User>();  
	  	users = userDaoImpl.getAllUsers();
	}

}
