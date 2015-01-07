package com.waylau.dao.base;

import java.io.Serializable;
import java.util.List;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
/**
 * 带分页的抽象类实现
 * 
 * @author waylau.com
 * @date 2015年1月2日
 */
@SuppressWarnings("unchecked")
public abstract class AbstractPageDao<E, PK extends Serializable> implements IBaseDao<E, PK> {
 
    protected Class<E> clazz;
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
 
    protected String from() {
        return "from " + getClazz().getName();
    }
 
    protected String count() {
        return "select count(*) " + from();
    }
 
    protected String where(String[] propertyNames, Object[] values) {
        StringBuilder accum = new StringBuilder(" where 1 = 1");
        for (int i = 0, len = propertyNames.length; i < len; i++) {
            accum.append(" and ");
            if (values[i] instanceof String) {
                accum.append(propertyNames[i]).append("='").append(values[i]).append("'");
            } else {
                accum.append(propertyNames[i]).append("=").append(values[i]);
            }
        }
        return accum.toString();
    }
 
    @Override
    public Class<E> getClazz() {
        return clazz;
    }
 
    @Override
    public List<E> pageAll(int page, int pageSize) {
        return pageByPropertys(new String[] {}, null, page, pageSize);
    }
 
    @Override
    public List<E> pageByPropertys(String[] propertyNames, Object[] values, int page, int pageSize) {
        Query query = getSession().createQuery(from() + where(propertyNames, values));
        int firstResult = (page - 1) * pageSize;
        query.setFirstResult(firstResult);
        query.setMaxResults(pageSize);
        return query.list();
    }
 
    @Override
    public List<E> pageByProperty(String propertyName, Object value, int page, int pageSize) {
        String[] propertyNames = { propertyName };
        Object[] values = { value };
        return pageByPropertys(propertyNames, values, page, pageSize);
    }
}
 