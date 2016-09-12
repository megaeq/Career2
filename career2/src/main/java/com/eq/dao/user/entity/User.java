package com.eq.dao.user.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.eq.dao.common.BaseEntity;
import com.eq.dao.system.entity.UserRoleRel;
@Entity
@Table(name="user")
public class User extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	private String password;
	@Column(name="is_lock",columnDefinition="tinyint default 0")
	private int isLock;//锁定，1为锁定，0为未锁定
	private String salt;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="user")
	@OrderBy(value = "id")
	private List<UserRoleRel> userRoleRelList;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<UserRoleRel> getUserRoleRelList() {
		return userRoleRelList;
	}
	public void setUserRoleRelList(List<UserRoleRel> userRoleRelList) {
		this.userRoleRelList = userRoleRelList;
	}
	public String getCredentialsSalt() {
		return userName+salt;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getIsLock()
	{
		return isLock;
	}
	public void setIsLock(int isLock)
	{
		this.isLock = isLock;
	}
	
	

}
