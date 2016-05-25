package com.eq.dao.command.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.eq.dao.common.BaseEntity;
@Entity
@Table(name="command_logger")
public class CommandLogger extends BaseEntity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String command;
	@Column(name = "create_date")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate;
	@Column(name="user_id")
	private Long userId;
	@Column(name="has_command")
	private Integer hasCommand;
	@Column(name="command_ids")
	private String commandIds;
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getCommand()
	{
		return command;
	}
	public void setCommand(String command)
	{
		this.command = command;
	}
	public Date getCreateDate()
	{
		return createDate;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	public Long getUserId()
	{
		return userId;
	}
	public void setUserId(Long userId)
	{
		this.userId = userId;
	}
	public Integer getHasCommand()
	{
		return hasCommand;
	}
	public void setHasCommand(Integer hasCommand)
	{
		this.hasCommand = hasCommand;
	}
	public String getCommandIds()
	{
		return commandIds;
	}
	public void setCommandIds(String commandIds)
	{
		this.commandIds = commandIds;
	}
	

}
