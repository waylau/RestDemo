
package com.waylau.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
 
import org.hibernate.Query;
 
/**
 * 泛型DAO实现
 * 
 * @author waylau.com
 * @date 2015年1月2日
 */
@SuppressWarnings("unchecked")
public class BaseDao4Hibernate<E, PK extends Serializable> extends AbstractPageDao<E, PK> implements IBaseDao<E, PK> {
 
    public BaseDao4Hibernate() {
        super.clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
 
    @Override
    public List<E> findAll() {
        return getSession().createQuery(from()).list();
    }
 
    @Override
    public void save(E e) {
        getSession().save(e);
    }
 
    @Override
    public void delete(E e) {
        getSession().delete(e);
    }
 
    @Override
    public void deleteByProperty(String propertyName, Object value) {
        List<E> es = findByProperty(propertyName, value);
        for (E e : es) {
            delete(e);
        }
    }
 
    @Override
    public List<E> findByProperty(String propertyName, Object value) {
        String[] propertyNames = { propertyName };
        Object[] values = { value };
        return findByPropertys(propertyNames, values);
    }
 
    @Override
    public List<E> findByPropertys(String[] propertyNames, Object[] values) {
        return getSession().createQuery(from() + where(propertyNames, values)).list();
    }
 
    @Override
    public long countAll() {
        return (long) getSession().createQuery(count()).uniqueResult();
    }
 
    @Override
    public long countByProperty(String propertyName, Object value) {
        String[] propertyNames = { propertyName };
        Object[] values = { value };
        return countByPropertys(propertyNames, values);
    }
 
    @Override
    public long countByPropertys(String[] propertyNames, Object[] values) {
        Query query = getSession().createQuery(count() + where(propertyNames, values));
        return (long) query.uniqueResult();
    }
 
    @Override
    public void saveOrUpdate(E e) {
        getSession().saveOrUpdate(e);
    }
 
    @Override
    public E findById(PK id) {
        return (E) getSession().get(getClazz(), id);
    }
 
    @Override
    public void update(E e) {
        getSession().update(e);
    }
 
    @Override
    public List<E> findAndOrderByProperty(int firstResult, int fetchSize, String propertyName, boolean isSequence) {
        String hql = from() + getOrder(propertyName, isSequence);
        Query query = getSession().createQuery(hql);
        query.setFirstResult(firstResult);
        query.setMaxResults(fetchSize);
        return query.list();
    }
 
    @Override
    public List<E> findAllAndOrderByProperty(String propertyName, boolean isSequence) {
        String hql = from() + getOrder(propertyName, isSequence);
        Query query = getSession().createQuery(hql);
        return query.list();
    }
 
    private String getOrder(String propertyName, boolean isSequence) {
        StringBuilder accum = new StringBuilder(" ");
        accum.append("order by ");
        accum.append(propertyName);
        accum.append(" ");
        accum.append(isSequence ? "asc" : "desc");
        return accum.toString();
    }
 
}