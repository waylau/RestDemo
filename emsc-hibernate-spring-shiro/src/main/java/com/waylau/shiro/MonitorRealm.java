package com.waylau.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.stereotype.Service;

import com.emsc.entity.SdUser;
import com.waylau.util.EncryptUtils;
 

@Service("monitorRealm")
public class MonitorRealm extends AuthorizingRealm {
	/*
	 * @Autowired UserService userService;
	 * 
	 * @Autowired RoleService roleService;
	 * 
	 * @Autowired LoginLogService loginLogService;
	 */

	public MonitorRealm() {
		super();

	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		/* 这里编写授权代码 */
		Set<String> roleNames = new HashSet<String>();
	    Set<String> permissions = new HashSet<String>();
	    roleNames.add("admin");
	    permissions.add("user.do?myjsp");
	    permissions.add("login.do?main");
	    permissions.add("login.do?logout");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
	    info.setStringPermissions(permissions);
		return info;

	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		/* 这里编写认证代码 */
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//		User user = securityApplication.findby(upToken.getUsername());
		SdUser user = new SdUser();
		//user.setUserToken(token.getUsername());
		user.setUsername("admin");
		user.setPassword(EncryptUtils.encryptMD5("admin"));
//		if (user != null) {
		return new SimpleAuthenticationInfo(user.getUsername(),
				user.getPassword(), getName());


	}

	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

}
