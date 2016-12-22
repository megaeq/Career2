package com.eq.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.eq.dao.user.entity.User;
import com.eq.dao.user.inte.IUser;

public class ShiroUtils
{String username = (String)getSubject().getPrincipals().getPrimaryPrincipal();
	@Autowired
	private static IUser iUser;
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}
	
	public static User getUser() {
		String username = (String)getSubject().getPrincipals().getPrimaryPrincipal();
		User user = iUser.findByUserName(username);
		return user;
	}
	
}
