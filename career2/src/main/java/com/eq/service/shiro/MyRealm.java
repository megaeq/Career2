package com.eq.service.shiro;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.eq.dao.system.entity.Permission;
import com.eq.dao.system.entity.Role;
import com.eq.dao.system.inte.IPermission;
import com.eq.dao.system.inte.IRole;
import com.eq.dao.user.entity.User;
import com.eq.dao.user.inte.IUser;

public class MyRealm extends AuthorizingRealm
{
	@Autowired
	private IUser iUser;
	@Autowired
	private IRole iRole;
	@Autowired
	private IPermission iPermission;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
	{
		String username = (String)principals.getPrimaryPrincipal();
		User user = iUser.findByUserName(username);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", user.getId());
		params.put("available", 1);
		List<Role> roleList = iRole.selectList(params);
		
		
		Set<String> roleSet = new HashSet<String>();
		Set<String> permissionSet = new HashSet<String>();
		for(int i=0;i<roleList.size();i++) {
			roleSet.add(roleList.get(i).getRole());
			params.clear();
			params.put("roleId", roleList.get(i).getId());
			params.put("available", 1);
			List<Permission> permissionList = iPermission.selectList(params);
			for(int j=0;j<permissionList.size();j++) {
				permissionSet.add(permissionList.get(j).getPermission());
			}
		}
		
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(roleSet);
        authorizationInfo.setStringPermissions(permissionSet);
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
	{
		String username = (String)token.getPrincipal();
		User user = userImpl.selectOne(username);
		if(user==null) {
			throw new UnknownAccountException();//没找到帐号
		}
		if(user.getLock()==1) {
			throw new LockedAccountException(); //帐号锁定
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getName(), //用户名
                user.getPwd(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()+"1991"),//salt=username+salt
                getName()  //realm name
        );
		return authenticationInfo;
	}

}
