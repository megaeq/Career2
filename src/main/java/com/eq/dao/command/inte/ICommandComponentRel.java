package com.eq.dao.command.inte;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eq.dao.command.entity.CommandComponentRel;

public interface ICommandComponentRel extends JpaRepository<CommandComponentRel, Long>
{

}
