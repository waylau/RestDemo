package com.waylau.rest.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import org.springframework.beans.factory.annotation.Autowired;

import com.waylau.rest.bean.User;
import com.waylau.rest.service.impl.UserServiceImpl;

/**
 * 用户资源
 * @author waylau.com
 * 2014-7-26
 */
@Path("/users")
public class UserResource {
    private static final Logger LOGGER = Logger.getLogger(UserResource.class.getName());
    
    @Autowired
    private UserServiceImpl userServiceImpl;
    
    public UserResource() {
        LOGGER.fine("UserResource()");
    }
    
	/**
	 * 增加
	 * @param user
	 */
	@POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createUser(User user)
    {
		userServiceImpl.createUser(user);
    }
	
	/**
	 * 删除
	 * @param id
	 */
    @DELETE
    @Path("{id}")
    public void deleteUser(@PathParam("id")String id){
    	userServiceImpl.deleteUserById(id);
    }
    
    /**
     * 修改
     * @param user
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateUser(User user){
		userServiceImpl.updateUser(user);
    }
 
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User getUserById(@PathParam("id") String id){
    	User u = userServiceImpl.getUserById(id);
    	return u;
    }
   
    /**
     * 查询所有
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> getAllUsers(){     
    	List<User> users = new ArrayList<User>();   
    	users = userServiceImpl.getAllUsers();
        return users;
    }
    
    
}
