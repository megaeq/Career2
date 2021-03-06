package com.eq.service.shiro;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.eq.dao.user.entity.User;


public class PasswordHelper
{
	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private static String algorithmName = "md5";
	private static final int hashIterations = 2;
	public static void encryptPassword(User user)
	{
		user.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()+"1991"), hashIterations).toHex();
		user.setPassword(newPassword);
	}
	
	public static boolean validatePassword(User user,String password) {
		return user.getPassword().equals(new SimpleHash(algorithmName, password, ByteSource.Util.bytes(user.getCredentialsSalt()+"1991"), hashIterations).toHex());
	}
}
