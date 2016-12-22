package com.eq.dao.system.inte;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eq.dao.system.entity.Permission;

public interface IPermission extends JpaRepository<Permission, Long> {
}
