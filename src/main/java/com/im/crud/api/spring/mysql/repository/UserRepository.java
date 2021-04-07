package com.im.crud.api.spring.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.im.crud.api.spring.mysql.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
