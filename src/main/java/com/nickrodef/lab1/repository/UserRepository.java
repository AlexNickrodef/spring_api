package com.nickrodef.lab1.repository;

import com.nickrodef.lab1.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
