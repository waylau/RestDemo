/**
 * 
 */
package com.emsc.dao.impl;

import org.springframework.stereotype.Repository;

import com.emsc.entity.SdUser;
import com.waylau.dao.base.BaseDao4Hibernate;

/**
 * @author waylau.com
 * 2015年1月3日
 */
@Repository
public class SdUserDaoImpl extends BaseDao4Hibernate<SdUser, Integer>  {

	public String sayHi(){
		return "hi girl";
	}
}
