package com.eq.dao.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.eq.dao.common.AbstractDao;
import com.eq.dao.system.entity.Role;
import com.google.common.collect.Maps;

public class IRoleImpl extends AbstractDao<Role> {
	@PersistenceContext
	private EntityManager em;
	public IRoleImpl() {
		super(Role.class);
	}

	@Override
	protected EntityManager getEM() {
		return em;
	}
	
	public List<Role> selectList(Map<String, Object> params) {
		String sql = "FROM Role WHERE 1=1 ";
		Map<String, Object> pps = Maps.newHashMap();
		if(null != params.get("role")) {
			sql+=" AND role = :role ";
			pps.put("role", params.get("role"));
		}
		if(null != params.get("name")) {
			sql+=" AND name = :name ";
			pps.put("name", params.get("name"));
		}
		if(null != params.get("available")) {
			sql+=" AND available=:available ";
			pps.put("available", params.get("available"));
		}
		if(null != params.get("user")) {
			sql+=" AND id IN(SELECT ur.role.id FROM UserRoleRel ur WHERE ur.user=:user) ";
			pps.put("user", params.get("user"));
		}
		sql+=" ORDER BY id";
		return findList(sql, pps);
	}

}
