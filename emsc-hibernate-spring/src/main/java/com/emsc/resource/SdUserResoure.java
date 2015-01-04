/**
 * 
 */
package com.emsc.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.emsc.entity.SdUser;
import com.emsc.service.impl.SdUserServiceImpl;

/**
 * SdUser　Resoure
 * 
 * @author waylau.com
 * 2015年1月3日
 */
@Path("/users")
@Component
public class SdUserResoure {

	@Autowired
	private  SdUserServiceImpl sdUserServiceImpl;
 
	
    /**
     * 查询所有
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SdUser> findAll(){     
    	List<SdUser> list = new ArrayList<SdUser>();   
    	list = sdUserServiceImpl.findAll();
        return list;
    }
 
    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it! Welcome to waylau's REST world!";
    }
    
    @GET
    @Path("/sum")
    @Produces(MediaType.TEXT_PLAIN)
    public Long countAll() {
    	long sum = sdUserServiceImpl.countAll();
		System.out.println(sum);
    	return sum;

    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SdUser findById(@PathParam("id") int id) {
		System.out.println(sdUserServiceImpl.findById(id).getRealname());
    	return sdUserServiceImpl.findById(id);
//    	SdUser e = new SdUser();
//    	e.setId(id);
//    	e.setPassword("SDFS");
//    	e.setRealname("的说法是否");
//    	e.setUsername("sdfsd");
//    	return e;
    }

 
}
