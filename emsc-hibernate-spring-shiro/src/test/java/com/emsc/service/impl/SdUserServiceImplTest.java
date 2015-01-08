/**
 * 
 */
package com.emsc.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emsc.entity.SdUser;
 
/**
 * @author waylau.com
 * 2015年1月3日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class SdUserServiceImplTest {

	@Autowired
	private SdUserServiceImpl sdUserServiceImpl;
	@Test
	public void sayHi() {
		System.out.println("hi world!");
	}
	
 
	
	@Test
	public void countAllTest() {
		System.out.println(sdUserServiceImpl.countAll());
	}
	@Test
	public void findAllTest() {
		System.out.println(sdUserServiceImpl.findAll());
	}
	
	@Test
	public void findByName() {
		String username = "chen";
		SdUser user =  sdUserServiceImpl.findByName(username);
		System.out.println(user.getRealname());
	}
}
