package com.ss.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.user_service.dao.UserRoleDao;
import com.ss.user_service.entity.UserRole;

@Service
public class UserRoleService {

	@Autowired
	UserRoleDao userRoleDao;
	
	public List<UserRole> getAllUserRoles(){
		return userRoleDao.findAll();
	}
}
