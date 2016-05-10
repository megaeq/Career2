package com.eq.dao.system.inte;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eq.dao.system.entity.Role;

public interface IRole extends JpaRepository<Role, Long> {

}
