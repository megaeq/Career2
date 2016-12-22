package com.eq.service.shiro;

import java.util.HashSet;
import java.util.List;
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
import com.eq.dao.system.entity.RolePermissionRel;
import com.eq.dao.system.entity.UserRoleRel;
import com.eq.dao.user.entity.User;
import com.eq.dao.user.inte.IUser;
import com.google.common.collect.Lists;

public class MyRealm extends AuthorizingRealm
{
	@Autowired
	private IUser iUser;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
	{
		String username = (String)principals.getPrimaryPrincipal();
		User user = iUser.findByUserName(username);
		List<Role> roleList = Lists.newArrayList();
		for(UserRoleRel ur:user.getUserRoleRelList()) {
			if(ur.getRole().getAvailable()==1) {
				roleList.add(ur.getRole());
			}
		}
		Set<String> roleSet = new HashSet<String>();
		Set<String> permissionSet = new HashSet<String>();
		for(int i=0;i<roleList.size();i++) {
			roleSet.add(roleList.get(i).getRole());
			List<Permission> permissionList = Lists.newArrayList();
			for(RolePermissionRel rp:roleList.get(i).getRolePermissionRelList()) {
				if(rp.getPermission().getAvailable()==1) {
					permissionList.add(rp.getPermission());
				}
			}
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
		User user = iUser.findByUserName(username);
		if(user==null) {
			throw new UnknownAccountException();//没找到帐号
		}
		if(user.getIsLock()==1) {
			throw new LockedAccountException(); //帐号锁定
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()+"1991"),//salt=username+salt
                getName()  //realm name
        );
		return authenticationInfo;
	}

}
