package com.waylau.rest.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
/**
 * Hibernate 初始化配置工具类
 * @author waylau.com
 * 2014-3-23
 */
public class HibernateUtil {
	 private static Configuration configuration;
	 private static SessionFactory sessionFactory;
	 private static StandardServiceRegistry standardServiceRegistry;
	    static {
	        try {
	         //第一步:读取Hibernate的配置文件  hibernamte.cfg.xml文件
	    	  configuration = new Configuration().configure("hibernate.cfg.xml");        
	    	 //第二步:创建服务注册构建器对象，通过配置对象中加载所有的配置信息
	          StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
	          sb.applySettings(configuration.getProperties());
	         //创建注册服务
	          standardServiceRegistry = sb.build();  
	        //第三步:创建会话工厂
	          sessionFactory = configuration.buildSessionFactory(standardServiceRegistry);   
	        } catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
}