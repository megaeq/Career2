package com.eq.dao.system.inte;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eq.dao.system.entity.Permission;

public interface IPermission extends JpaRepository<Permission, Long> {

}
