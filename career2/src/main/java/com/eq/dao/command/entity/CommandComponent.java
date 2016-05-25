package com.eq.dao.command.entity;

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

import com.eq.dao.common.BaseEntity;
@Entity
@Table(name="command_component")
public class CommandComponent extends BaseEntity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String value;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="commandComponent")
	@OrderBy(value = "id")
	private List<CommandComponentRel> commandComponentRelList;
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getValue()
	{
		return value;
	}
	public void setValue(String value)
	{
		this.value = value;
	}
	public List<CommandComponentRel> getCommandComponentRelList()
	{
		return commandComponentRelList;
	}
	public void setCommandComponentRelList(List<CommandComponentRel> commandComponentRelList)
	{
		this.commandComponentRelList = commandComponentRelList;
	}
	

}
