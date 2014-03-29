package com.waylau.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;


import com.waylau.rest.bean.User;

 
/**
 * 用户客户端，用来测试资源
 * @author waylau.com
 * 2014-3-18
 */
public class UserClient {

	private static String serverUri = "http://localhost:8089/RestDemo/rest";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//addUser();
		//getAllUsersXml();
		//getAllUsers();
		//updateUser();
 //getUserById();
//		getAllUsers();
 //delUser();
        getAllUsers();
		//getAllUsersXml();
		
		//getUserJson();
		
		
	}
	/**
	 * 添加用户
	 */
	 private static void addUser() {
		 System.out.println("****增加用户addUser****");
		 User user = new User("006","Susan","21");  
		 Client client = ClientBuilder.newClient();
		 WebTarget target = client.target(serverUri + "/users");
		 Response response = target.request().buildPost(Entity.entity(user, MediaType.APPLICATION_XML)).invoke();
		 response.close();
    }
	 
	/**
	 * 删除用户
	 */
	 private static void delUser() {
		 System.out.println("****删除用户****");
		 Client client = ClientBuilder.newClient();
		 WebTarget target = client.target(serverUri + "/users/006");
		 Response response = target.request().delete();
		 response.close();
	}
	 
	 
	/**
	 * 修改用户
	 */
	 private static void updateUser() {
		 System.out.println("****修改用户updateUser****");
		 User user = new User("006","Susan","33");  
		 Client client = ClientBuilder.newClient();
		 WebTarget target = client.target(serverUri + "/users");
		 Response response = target.request().buildPut( Entity.entity(user, MediaType.APPLICATION_XML)).invoke();
		 response.close();
    }
	/**
	 * 根据id查询用户
	 */
	 private static void getUserById() {
		 System.out.println("****根据id查询用户****");
		 Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);// 注册json 支持
		 WebTarget target = client.target(serverUri + "/users/006");
		 Response response = target.request().get();
		 User user = response.readEntity(User.class);
		 System.out.println(user.getUserId() + user.getUserName()  +  user.getAge());
		 response.close();
    }
	/**
	 * 查询所有用户
	 */
	 private static void getAllUsers() {
		 System.out.println("****查询所有getAllUsers****");
		 
		 Client client = ClientBuilder.newClient();//.register(JacksonJsonProvider.class);// 注册json 支持

		 WebTarget target = client.target(serverUri + "/users");
		 Response response = target.request().get();
    	 //xml转成List对象集合; readEntity方法的参数需要传递泛型对象List的类型
    	 //List<User> users = response.readEntity(new GenericType<List<User>>(){});
	     String value = response.readEntity(String.class);
    	 System.out.println(value);
//    	 
//    	 for(User user:users ){
//    		 System.out.println(user.getUserId() + user.getUserName()  +  user.getAge());
//    	 }
//    	 
         response.close();  //关闭连接
	 }
	/**
	 * 查询所有用户
	 */
	 private static void getAllUsersXml() {
		 System.out.println("****查询所有getAllUsersXml****");
		 
		 Client client = ClientBuilder.newClient();
		 WebTarget target = client.target(serverUri + "/users");
		 Response response = target.request().get();
		 String value = response.readEntity(String.class);
    	 System.out.println(value);
         response.close();  //关闭连接
	 }
	/**
	 * 查询用户xml
	 */
	 private static void getUserXml() {
		 System.out.println("****查询用户getUserXml****");
		 
		 Client client = ClientBuilder.newClient();
		 WebTarget target = client.target(serverUri + "/users/getUserXml");
		 Response response = target.request().get();
	     String value = response.readEntity(String.class);
         response.close();  //关闭连接
    	 System.out.println(value);

	 }
	/**
	 * 查询用户JSON
	 */
	 private static void getUserJson() {
		 System.out.println("****查询用户getUserJson****");
		 
		 Client client = ClientBuilder.newClient();
		 WebTarget target = client.target(serverUri + "/users/getUserJson");
		 Response response = target.request().get();
	     String value = response.readEntity(String.class);
         response.close();  //关闭连接
    	 System.out.println(value);

	 }
}
