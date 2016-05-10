package com.eq.dao.user.inte;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eq.dao.user.entity.User;

public interface IUser extends JpaRepository<User, Long>  {
	public Page<User> findByUserName(String userName,Pageable pageable);
	public User findByUserName(String userName);
	public List<User> selectList(Map<String, Object> params);
}
