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
 * 权限表
 */
import com.eq.dao.common.BaseEntity;
@Entity
@Table(name="Permission")
public class Permission extends BaseEntity
{

	/**
	 * @fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	//private String username;
	private String permission;
	private int available;//是否激活
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="permission")
	@OrderBy(value = "id")
	private List<RolePermissionRel> rolePermissionRelList;
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getPermission()
	{
		return permission;
	}
	public void setPermission(String permission)
	{
		this.permission = permission;
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

}
