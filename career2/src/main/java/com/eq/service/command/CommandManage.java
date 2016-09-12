package com.eq.service.command;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("command")
public class CommandManage 
{
	
	@RequestMapping("process")
	public void process() {
		
	}
	@RequestMapping("getfooter")
	public String getfooter(Integer i,Integer j) {
		System.out.println(i+":"+j);
		return "/index";
	}
}
