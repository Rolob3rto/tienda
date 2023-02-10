package com.rolob3rto.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolob3rto.springprojects.tienda.model.Permission;



@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
