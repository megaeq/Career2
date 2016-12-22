package com.eq.service.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.sf.ehcache.CacheManager;
@Service
public class BaseService
{
	protected HttpServletRequest request;  
    protected HttpServletResponse response; 
    public CacheManager singletonManager;
    @ModelAttribute
    public void init(HttpServletRequest request, HttpServletResponse response) {
    	this.request = request;  
        this.response = response; 
        singletonManager = CacheManager.create();
    }
    public Subject getSubject() {
		return SecurityUtils.getSubject();
	}
}
