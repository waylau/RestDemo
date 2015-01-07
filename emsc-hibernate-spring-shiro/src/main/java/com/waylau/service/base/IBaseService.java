
package com.waylau.service.base;

import java.io.Serializable;
import java.util.List;

/**
 * Service 基类接口
 * 
 * @author waylau.com
 * 2015年1月3日
 */
public interface IBaseService <E, PK extends Serializable> {
 
    /**
     * 获取当前对象的所有记录
     * @return 所有记录
     */
    List<E> findAll();
 
    /**
     * 查找所有，并分页
     * 
     * @param page 要返回的页数
     * @param pageSize 没有记录数
     * @return
     */
    List<E> pageAll(int page, int pageSize);
 
    /**
     * 保存对象
     * @param e 对象
     */
    void save(E e);
 
    /**
     * 删除对象
     * @param e 对象
     */
    void delete(E e);
 
    /**
     * 与findByProperty相似，当properyName == value 时把相应的记录删除
     */
    void deleteByProperty(String propertyName, Object value);
 
    /**
     * 通过属性查找
     * 
     * @param propertyName 属性名称
     * @param value 属性的值
     * @return
     */
    List<E> findByProperty(String propertyName, Object value);
 
    /**
     * 通过多个属性查找
     * 
     * @param propertyNames 属性名称数组
     * @param values 属性值数组
     * @return
     */
    List<E> findByPropertys(String[] propertyNames, Object[] values);
 
    /**
     * 通过多个属性查找，并分页， 属性名称数组和属性值数组的序列要对应
     * 
     * @param propertyNames 属性名称数组
     * @param values 属性值数组
     * @param page 页码
     * @param pageSize 每页内容条数
     * @return 分页后的结果
     */
    List<E> pageByPropertys(String[] propertyNames, Object[] values, int page, int pageSize);
 
    /**
     * 通过属性查找，并分页， 属性名称数组和属性值数组的序列要对应
     * 
     * @param propertyNames 属性名称
     * @param values 属性值
     * @param page 页码
     * @param pageSize 每页内容条数
     * @return
     */
    List<E> pageByProperty(String propertyName, Object value, int page, int pageSize);
 
    /**
     * 统计所有记录的总数
     * 
     * @return 总数
     */
    long countAll();
 
    /**
     * 统计数据库中当propertyName=value时的记录总数
     * 
     * @param propertyName
     * @param value
     * @return
     */
    long countByProperty(String propertyName, Object value);
 
    /**
     * 统计数据库中当多个propertyName=value时的记录总数
     * 
     * @param propertyNames
     * @param values
     * @return
     */
    long countByPropertys(String[] propertyNames, Object[] values);
 
    /**
     * 保存或更新
     * @param e
     */
    void saveOrUpdate(E e);
 
    /**
     * 通过ID查询对象
     * @param id 主键编号
     * @return
     */
    E findById(PK id);
 
    /**
     * 更新对象
     * @param e
     */
    void update(E e);
 
    /**
     * 获得持久化对象的类型
     * 
     * @return
     */
    Class<E> getClazz();
 
    /**
     * 查找并通过某一属性排序
     * 
     * @param property 排序依据的顺序
     * @param isSequence 是否顺序排序
     */
    List<E> findAndOrderByProperty(int firstResult, int fetchSize, String propertyName, boolean isSequence);
 
    /**
     * 查找并通过某一属性排序
     * 
     * @param property 排序依据的顺序
     * @param isSequence 是否顺序排序
     */
    List<E> findAllAndOrderByProperty(String propertyName, boolean isSequence);
    
}