
package com.emsc.rest;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;


/** 
 * REST 主应用 
 * 
 * @author waylau.com 
 * 2014-12-23 
 */  
public class RestApplication extends ResourceConfig {  
    public RestApplication() {  

     //服务类所在的包路径  
     packages("com.emsc.resource");  
     //注册 JSON 转换器  
     register(MoxyJsonFeature.class);

    }  
}  
