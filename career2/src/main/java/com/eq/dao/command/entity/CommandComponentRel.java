package com.eq.dao.command.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eq.dao.common.BaseEntity;
@Entity
@Table(name="command_component_rel")
public class CommandComponentRel extends BaseEntity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Command command;
	@ManyToOne
	private CommandComponent commandComponent;
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public Command getCommand()
	{
		return command;
	}
	public void setCommand(Command command)
	{
		this.command = command;
	}
	public CommandComponent getCommandComponent()
	{
		return commandComponent;
	}
	public void setCommandComponent(CommandComponent commandComponent)
	{
		this.commandComponent = commandComponent;
	}

}
