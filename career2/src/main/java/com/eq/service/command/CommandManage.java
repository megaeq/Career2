package com.eq.service.command;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("command")
public class CommandManage 
{
	
	@RequestMapping("process")
	@ResponseBody
	public String process(String command) {
		System.out.println(command);
		return "[\"你\",\"好\",\"啊\"]";
	}
	@RequestMapping("getfooter")
	public String getfooter(Integer i,Integer j) {
		System.out.println(i+":"+j);
		return "/index";
	}
}
