package com.waylau.rest;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

import com.waylau.rest.bean.User;
/**
 * 应用
 * @author waylau.com
 * 2014-3-18
 */
public class RestApplication extends ResourceConfig {
    public RestApplication() {
    //加载Bean
     register(User.class);

     //服务类所在的包路径
     packages("com.waylau.rest.resources");
     //注册JSON转换器
     register(JacksonJsonProvider.class);
      //打印访问日志，便于跟踪调试，正式发布可清除 
     register(LoggingFilter.class);
    }
}