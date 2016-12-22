package com.eq.dao.command.entity;

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
@Entity
@Table(name="command")
public class Command extends BaseEntity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer type;
	private String name;
	private String value;
	@Column(columnDefinition=" int default 0")
	private Long times;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="command")
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
	public Integer getType()
	{
		return type;
	}
	public void setType(Integer type)
	{
		this.type = type;
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
	public Long getTimes()
	{
		return times;
	}
	public void setTimes(Long times)
	{
		this.times = times;
	}
	

}
