/**
 * 
 */
package com.eq.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eq.dao.user.entity.User;
import com.eq.dao.user.inte.IUser;
import com.eq.service.shiro.PasswordHelper;

/**
 * @author wisdom
 *
 */
@Component
@RequestMapping("user")
public class UserService {
	@Autowired
	private IUser iUser;
	@RequestMapping("add")
	public void add(String username,String password) {
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		user.setSalt(UUID.randomUUID().toString());
		PasswordHelper.encryptPassword(user);
		iUser.save(user);
	}
}
