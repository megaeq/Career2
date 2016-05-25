package com.eq.service.command;

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
	public String getfooter() {
		return "/index";
	}
}
