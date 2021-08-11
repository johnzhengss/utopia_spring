package com.ss.user_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.user_service.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
