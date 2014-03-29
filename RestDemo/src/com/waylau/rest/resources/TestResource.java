package com.waylau.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class TestResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Test!" ;
	}
	
	@GET
	@Path("/{param}")  
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloTo(@PathParam("param") String username) {
		return "test " + username;
	}
}
