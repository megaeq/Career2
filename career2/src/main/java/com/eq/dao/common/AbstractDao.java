package com.eq.dao.common;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.lang.StringUtils;

public abstract class AbstractDao<E extends BaseEntity>  {
	protected Class<E> entityClass;

	public AbstractDao(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public Long count(String qlString, Map<String, Object> paramValues) {
		TypedQuery<Long> countQuery = getEM().createQuery(qlString, Long.class);
		setParametersToQuery(countQuery, paramValues);
		try {
			return countQuery.getSingleResult();
		} catch (NoResultException e) {
			return 0l;
		}
	}

	public Long count(String qlString, Object... values) {
		TypedQuery<Long> countQuery = getEM().createQuery(qlString, Long.class);
		setParametersToQuery(countQuery, values);
		try {
			return countQuery.getSingleResult();
		} catch (NoResultException e) {
			return 0l;
		}

	}

	public <X> List<X> findList(String qlString, Class<X> retType,
			Map<String, Object> paramValues) {
		TypedQuery<X> query = getEM().createQuery(qlString, retType);
		setParametersToQuery(query, paramValues);
		return query.getResultList();
	}

	public <X> List<X> findList(String qlString, Class<X> retType,
			Object... values) {
		TypedQuery<X> query = getEM().createQuery(qlString, retType);
		setParametersToQuery(query, values);
		return query.getResultList();
	}

	public List<E> findList(String qlString, Map<String, Object> paramValues) {
		TypedQuery<E> query = getEM().createQuery(qlString, this.entityClass);
		setParametersToQuery(query, paramValues);
		return query.getResultList();
	}

	public List<E> findList(String qlString, Object... values) {
		TypedQuery<E> query = getEM().createQuery(qlString, this.entityClass);
		setParametersToQuery(query, values);
		return query.getResultList();
	}

	public E findOne(String qlString, Map<String, Object> paramValues) {
		TypedQuery<E> query = getEM().createQuery(qlString, this.entityClass);
		setParametersToQuery(query, paramValues);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public E findOne(String qlString, Object... values) {
		TypedQuery<E> query = getEM().createQuery(qlString, this.entityClass);
		setParametersToQuery(query, values);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public <X> List<X> findPageList(String qlString, Class<X> retType,
			int startRow, int pageSize, Map<String, Object> paramValues) {
		assert startRow >= 0;
		assert pageSize >= 0;

		TypedQuery<X> query = getEM().createQuery(qlString, retType);
		setParametersToQuery(query, paramValues);
		if (pageSize != 0)
			query.setFirstResult(startRow).setMaxResults(pageSize);
		return query.getResultList();
	}

	public <X> List<X> findPageList(String qlString, Class<X> retType,
			int startRow, int pageSize, Object... values) {
		assert startRow >= 0;
		assert pageSize >= 0;

		TypedQuery<X> query = getEM().createQuery(qlString, retType);
		setParametersToQuery(query, values);
		if (pageSize != 0)
			query.setFirstResult(startRow).setMaxResults(pageSize);
		return query.getResultList();
	}

	public List<E> findPageList(String qlString, int startRow, int pageSize,
			Map<String, Object> paramValues) {
		assert startRow >= 0;
		assert pageSize >= 0;

		TypedQuery<E> query = getEM().createQuery(qlString, this.entityClass);
		setParametersToQuery(query, paramValues);
		if (pageSize != 0)
			query.setFirstResult(startRow).setMaxResults(pageSize);
		return query.getResultList();
	}

	public List<E> findPageList(String qlString, int startRow, int pageSize,
			Object... values) {
		assert startRow >= 0;
		assert pageSize >= 0;

		TypedQuery<E> query = getEM().createQuery(qlString, this.entityClass);
		setParametersToQuery(query, values);
		if (pageSize != 0)
			query.setFirstResult(startRow).setMaxResults(pageSize);
		return query.getResultList();
	}

	protected abstract EntityManager getEM();

	/**
	 * @title paramValueOfLikeOperator
	 * @description 返回指定字串的LIKE条件操作符需要的字串格式。在str前后加上%。
	 * @param str
	 * @return
	 * @return String
	 * @throws
	 */
	protected String paramValueOfLikeOperator(String str) {
		assert StringUtils.isNotBlank(str);

		return "%" + str.trim() + "%";
	}

	protected void setParametersToQuery(Query query,
			Map<String, Object> paramValues) {
		for (Map.Entry<String, Object> entry : paramValues.entrySet())
			query.setParameter(entry.getKey(), entry.getValue());
	}

	protected void setParametersToQuery(Query query, Object... values) {
		for (int i = 1; i <= values.length; i++)
			query.setParameter(i, values[i - 1]);
	}
}
