package com.eq.user;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eq.dao.user.entity.User;
import com.eq.dao.user.inte.IUser;
import com.eq.service.user.UserService;
import com.google.common.collect.Maps;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserTest {
	@Resource
	private UserService userService;
	@Resource
	private IUser iUser;
	//@Test
	public void add() {
		//userService.add();
		User user = new User();
		user.setPassword("123456");
		user.setUserName("mm");
		iUser.save(user);
	}
	@Test
	public void add2() {
		System.out.println(userService.add("bake2", "123456"));
	}
	//@Test
	public void login() {
		System.out.println(userService.login("bake1", "123456"));
	}
	//@Test
	public void update() {
		User user = iUser.findOne(1l);
		user.setUserName("aa");
		iUser.save(user);
	}
	//@Test
	public void getrole() {
		User user = iUser.findOne(1l);
		System.out.println(user.getUserRoleRelList().get(0).getRole().getName());
	}
	
	//@Test
	public void findByUserName() {
		Sort sort = new Sort(Sort.Direction.ASC,"id").and(new Sort(Sort.Direction.DESC,"userName"));
		Pageable pageable = new PageRequest(0, 2,sort);
		
		Page<User> page = iUser.findByUserName("mm", pageable);
		List<User> list = iUser.selectList(Maps.newHashMap());
		System.out.println(list.size());
		//JsonUtils.prettyPrintedJson(page.getContent().get(0));
	}
	
}
