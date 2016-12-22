package com.eq.dao.command.inte;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eq.dao.command.entity.CommandComponent;

public interface ICommandComponent extends JpaRepository<CommandComponent, Long>
{

}
