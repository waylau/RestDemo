/**
 * 
 */
package com.emsc.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.emsc.entity.SdUser;

/**
 * @author waylau.com 2015年1月3日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestSdUserDaoImpl {

	@Autowired
	private SdUserDaoImpl sdUserDaoImpl;
	@Test
	public void sayHi() {
		System.out.println("hi world!");
	}
	
	@Test
	public void sayHiTest() {
		System.out.println(sdUserDaoImpl.sayHi());
	}
	
	@Test
	public void countAllTest() {
		System.out.println(sdUserDaoImpl.countAll());
	}
	@Test
	public void findByIdTest() {
		SdUser e = sdUserDaoImpl.findById(1);
		
		System.out.println(e.getRealname());
	}
	
}
