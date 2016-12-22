package com.eq.dao.system.inte;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eq.dao.system.entity.UserRoleRel;

public interface IUserRoleRel extends JpaRepository<UserRoleRel, Long> {

}
