package com.emsc.resource;

import java.util.Collections;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import org.glassfish.jersey.server.mvc.Template;
//import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.stereotype.Component;
 

/**
 * 测试用的 Resource
 * 
 * @author waylau.com
 * 2015年1月3日
 */
@Path("login")
@Component
public class LoginResource {

 //   @Produces("text/html")
//    public Viewable form() {
//        return new Viewable("/form",
//                Collections.singletonMap("greeting", "Link Shortener"));
//    }
 
}
