package com.eq.service.command;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eq.dao.command.entity.Command;
import com.eq.dao.command.inte.ICommand;
import com.google.common.collect.Lists;

@Component
@RequestMapping("command")
public class CommandManage 
{
	@Autowired
	private ICommand iCommand;
	@RequestMapping("process")
	@ResponseBody
	public String process(String command) {
		System.out.println(command);
		
		return "[\"你\",\"好\",\"啊\"]";
	}
	@RequestMapping("getCommandList")
	@ResponseBody
	public List<String> getCommandList(String command) {
		List<String> resultList = Lists.newArrayList();
		if(command.startsWith("cmd:")||command.startsWith("cmd：")||command.startsWith("c:")||command.startsWith("c：")) {
			String cmd = "%"+command.replace("cmd:", "").replace("cmd：", "").replace("c:", "").replace("c：", "")+"%";
			Sort sort = new Sort(Sort.Direction.DESC,"times");
			Pageable pageable = new PageRequest(0, 6,sort);
			List<Command> list = iCommand.findByNameLikeOrValueLike(cmd, cmd, pageable);
			for(Command c:list) {
				resultList.add("cmd:"+c.getValue());
			}
		}
		return resultList;
	}
	
	
	@RequestMapping("getfooter")
	public String getfooter(Integer i,Integer j) {
		System.out.println(i+":"+j);
		return "/index";
	}
}
