/**
 * 
 */
package com.emsc.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
/**
 * @author waylau.com
 * 2015年1月3日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestSdUserServiceImpl {

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
}
