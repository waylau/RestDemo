package com.emsc.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.emsc.entity.UserEntity;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @GET  
    @Path("/userJson")  
    @Produces(MediaType.APPLICATION_JSON)  
    public UserEntity getUserJson() {  
    	UserEntity user  = new UserEntity();  
     user.setAge("27");  
     user.setUserId(005);  
     user.setUserName("Fmand");  
     return user;  
    }  
}
