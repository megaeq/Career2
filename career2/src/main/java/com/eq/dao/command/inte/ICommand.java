package com.eq.dao.command.inte;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eq.dao.command.entity.Command;

public interface ICommand extends JpaRepository<Command, Long>
{
	public List<Command> findByNameLikeOrValueLike(String name,String value,Pageable pageable);
}
