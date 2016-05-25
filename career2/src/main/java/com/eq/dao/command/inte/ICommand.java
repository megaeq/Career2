package com.eq.dao.command.inte;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eq.dao.command.entity.Command;

public interface ICommand extends JpaRepository<Command, Long>
{

}
