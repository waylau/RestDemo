package com.emsc.resource;

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
public class SdUserResoureTest {
	@Autowired
	private SdUserResoure sdUserResoure;

	@Test
	public void getItTest() {
		System.out.println(sdUserResoure.getIt());
	}
	@Test
	public void countAll() {
		System.out.println("test:"+sdUserResoure.countAll());
	}
}
