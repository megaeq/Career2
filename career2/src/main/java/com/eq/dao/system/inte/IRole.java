package com.eq.dao.system.inte;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eq.dao.system.entity.Role;

public interface IRole extends JpaRepository<Role, Long> {
	public List<Role> selectList(Map<String, Object> params);
}
