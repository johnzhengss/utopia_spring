package com.ss.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.user_service.dao.UserDao;
import com.ss.user_service.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> getAllUsers(){
		return userDao.findAll();
	}
}
