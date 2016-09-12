/**
 * 
 */
package com.eq.service.user;

import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eq.dao.user.entity.User;
import com.eq.dao.user.inte.IUser;
import com.eq.service.common.BaseService;
import com.eq.service.shiro.PasswordHelper;

/**
 * @author wisdom
 *
 */
@Component
@RequestMapping("user")
public class UserService extends BaseService {
	@Autowired
	private IUser iUser;
	@RequestMapping("add")
	@ResponseBody
	public String add(String username,String password) {
		User user = iUser.findByUserName(username);
		if(user==null) {
			user = new User();
			user.setUserName(username);
			user.setPassword(password);
			PasswordHelper.encryptPassword(user);
			iUser.save(user);
			return "注册成功";
		} else {
			return "用户名已存在";
		}
	}
	@RequestMapping("login")
	@ResponseBody
	public String login(String username,String password) {
		//验证账户、密码有效性
		User user = iUser.findByUserName(username);
		if(user == null){
			return "用户不存在或密码错误";
		}
		if(!PasswordHelper.validatePassword(user, password)) {
			return "密码错误或用户不存在";
		}
		Subject subject = getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password, true);
		subject.login(token);
		return "登陆成功";
	}
}
