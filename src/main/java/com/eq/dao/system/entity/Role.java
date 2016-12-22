package com.eq.dao.system.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
/**
 * 角色表
 */
import com.eq.dao.common.BaseEntity;
import com.eq.dao.user.entity.User;
@Entity
@Table(name="role")
public class Role extends BaseEntity
{

	/**
	 * @fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String role;
	private String name;
	//private String username;
	private int available;//是否激活
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="role")
	@OrderBy(value = "id")
	private List<RolePermissionRel> rolePermissionRelList;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="role")
	@OrderBy(value = "id")
	private List<UserRoleRel> userRoleRelList;
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getRole()
	{
		return role;
	}
	public void setRole(String role)
	{
		this.role = role;
	}
	public int getAvailable()
	{
		return available;
	}
	public void setAvailable(int available)
	{
		this.available = available;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public List<RolePermissionRel> getRolePermissionRelList() {
		return rolePermissionRelList;
	}
	public void setRolePermissionRelList(List<RolePermissionRel> rolePermissionRelList) {
		this.rolePermissionRelList = rolePermissionRelList;
	}
	public List<UserRoleRel> getUserRoleRelList() {
		return userRoleRelList;
	}
	public void setUserRoleRelList(List<UserRoleRel> userRoleRelList) {
		this.userRoleRelList = userRoleRelList;
	}

}
