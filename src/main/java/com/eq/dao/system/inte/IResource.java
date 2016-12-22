package com.eq.dao.system.inte;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eq.dao.system.entity.Resource;

public interface IResource extends JpaRepository<Resource, Long> {

}
