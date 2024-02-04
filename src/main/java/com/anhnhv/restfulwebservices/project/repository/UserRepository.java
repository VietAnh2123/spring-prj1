package com.anhnhv.restfulwebservices.project.repository;

import com.anhnhv.restfulwebservices.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
