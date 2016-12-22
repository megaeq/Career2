package com.eq.dao.user.impl;


import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.eq.dao.common.AbstractDao;
import com.eq.dao.user.entity.User;
import com.google.common.collect.Maps;


public class IUserImpl extends AbstractDao<User>{
	@PersistenceContext
	private EntityManager em;
	public IUserImpl() {
		super(User.class);
	}
	public List<User> selectList(Map<String, Object> params) {
		String sql = "FROM User WHERE 1=1 ";
		Map<String, Object> pps = Maps.newHashMap();
		if(null != params.get("userName")) {
			sql+=" AND userName=:userName";
			pps.put("userName", params.get("userName"));
		}
		sql+=" ORDER BY id DESC";
		return findList(sql, pps);
	}
	@Override
	protected EntityManager getEM() {
		return em;
	}
}
