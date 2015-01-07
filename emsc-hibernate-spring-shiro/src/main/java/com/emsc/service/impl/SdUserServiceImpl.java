/**
 * 
 */
package com.emsc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsc.dao.impl.SdUserDaoImpl;
import com.emsc.entity.SdUser;
import com.emsc.service.ISdUserService;

/**
 * @author waylau.com
 * 2015年1月3日
 */
@Service
public class SdUserServiceImpl implements ISdUserService {

    @Autowired
    private SdUserDaoImpl  sdUserDaoImpl;
  
	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#findAll()
	 */
	@Override
	public List<SdUser> findAll() {
		// TODO Auto-generated method stub
		return sdUserDaoImpl.findAll();
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#pageAll(int, int)
	 */
	@Override
	public List<SdUser> pageAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return sdUserDaoImpl.pageAll(page, pageSize);
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#save(java.lang.Object)
	 */
	@Override
	public void save(SdUser e) {
		// TODO Auto-generated method stub
		sdUserDaoImpl.save(e);
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#delete(java.lang.Object)
	 */
	@Override
	public void delete(SdUser e) {
		// TODO Auto-generated method stub
		sdUserDaoImpl.delete(e);
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#deleteByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public void deleteByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		sdUserDaoImpl.deleteByProperty(propertyName, value);
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<SdUser> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return sdUserDaoImpl.findByProperty(propertyName, value);
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#findByPropertys(java.lang.String[], java.lang.Object[])
	 */
	@Override
	public List<SdUser> findByPropertys(String[] propertyNames, Object[] values) {
		// TODO Auto-generated method stub
		return sdUserDaoImpl.findByPropertys(propertyNames, values);
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#pageByPropertys(java.lang.String[], java.lang.Object[], int, int)
	 */
	@Override
	public List<SdUser> pageByPropertys(String[] propertyNames,
			Object[] values, int page, int pageSize) {
		// TODO Auto-generated method stub
		return sdUserDaoImpl.pageByPropertys(propertyNames, values, page, pageSize);
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#pageByProperty(java.lang.String, java.lang.Object, int, int)
	 */
	@Override
	public List<SdUser> pageByProperty(String propertyName, Object value,
			int page, int pageSize) {
		// TODO Auto-generated method stub
		return sdUserDaoImpl.pageByProperty(propertyName, value, page, pageSize);
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#countAll()
	 */
	@Override
	public long countAll() {
		// TODO Auto-generated method stub
		return sdUserDaoImpl.countAll();
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#countByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public long countByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return sdUserDaoImpl.countByProperty(propertyName, value);
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#countByPropertys(java.lang.String[], java.lang.Object[])
	 */
	@Override
	public long countByPropertys(String[] propertyNames, Object[] values) {
		// TODO Auto-generated method stub
		return sdUserDaoImpl.countByPropertys(propertyNames, values);
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(SdUser e) {
		// TODO Auto-generated method stub
		sdUserDaoImpl.saveOrUpdate(e);
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#findById(java.io.Serializable)
	 */
	@Override
	public SdUser findById(Integer id) {
		// TODO Auto-generated method stub
		return sdUserDaoImpl.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#update(java.lang.Object)
	 */
	@Override
	public void update(SdUser e) {
		// TODO Auto-generated method stub
		sdUserDaoImpl.update(e);
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#getClazz()
	 */
	@Override
	public Class<SdUser> getClazz() {
		// TODO Auto-generated method stub
		return sdUserDaoImpl.getClazz();
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#findAndOrderByProperty(int, int, java.lang.String, boolean)
	 */
	@Override
	public List<SdUser> findAndOrderByProperty(int firstResult, int fetchSize,
			String propertyName, boolean isSequence) {
		// TODO Auto-generated method stub
		return sdUserDaoImpl.findAndOrderByProperty(firstResult, fetchSize, propertyName, isSequence);
	}

	/* (non-Javadoc)
	 * @see com.waylau.service.base.IBaseService#findAllAndOrderByProperty(java.lang.String, boolean)
	 */
	@Override
	public List<SdUser> findAllAndOrderByProperty(String propertyName,
			boolean isSequence) {
		// TODO Auto-generated method stub
		return sdUserDaoImpl.findAllAndOrderByProperty(propertyName, isSequence);
	}

	@Override
	public SdUser findByName(String username){
		List<SdUser> users = findByProperty("username",username);
		SdUser user = null;
		if( users!=null && users.size()>0 ){
			user = users.get(0) ;
		}
		return user;
	}
}
