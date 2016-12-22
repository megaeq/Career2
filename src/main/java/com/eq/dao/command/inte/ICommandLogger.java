package com.eq.dao.command.inte;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eq.dao.command.entity.CommandLogger;

public interface ICommandLogger extends JpaRepository<CommandLogger, Long>
{

}
