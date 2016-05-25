package com.eq.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtils
{
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}
	
}
