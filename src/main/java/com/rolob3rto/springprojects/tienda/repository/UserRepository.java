package com.rolob3rto.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolob3rto.springprojects.tienda.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByNombre(String userName);
}
