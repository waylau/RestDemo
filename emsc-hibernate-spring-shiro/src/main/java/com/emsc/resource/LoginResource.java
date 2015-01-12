package com.emsc.resource;

import java.util.Collections;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;









import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
//import org.glassfish.jersey.server.mvc.Template;
//import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.stereotype.Component;

import com.waylau.entity.ResultBean;
import com.waylau.util.EncryptUtils;
 

/**
 * 测试用的 Resource
 * 
 * @author waylau.com
 * 2015年1月3日
 */
@Path("login")
@Component
public class LoginResource {

	/**
	 * 校验登录
	 * @author waylau.com
	 * 2015年1月3日
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResultBean login(@FormParam("username") String username, @FormParam("password") String password) {
 
		ResultBean resultBean = new ResultBean();
		
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(
				username, EncryptUtils.encryptMD5( password ));
		token.setRememberMe(true);
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			resultBean.setSuccess(false);
			resultBean.setMessage("login errors");
			resultBean.setOther("/login.html");
			e.printStackTrace();
		}
		if(currentUser.isAuthenticated()){
			resultBean.setSuccess(true);
			resultBean.setMessage("login success");
			resultBean.setOther("/admin.html");
		}else{
			resultBean.setSuccess(false);
			resultBean.setMessage("login errors");
			resultBean.setOther("/login.html");
		}
		
		return resultBean;
		
	}
}
