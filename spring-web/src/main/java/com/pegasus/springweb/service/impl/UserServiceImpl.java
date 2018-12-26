package com.pegasus.springweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pegasus.springweb.dao.IUserDao;
import com.pegasus.springweb.domain.User;
import com.pegasus.springweb.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	public User login(String username, String password) {
		
		User user=userDao.selectByUsername(username);
		
		if(null!=user) {
			if(user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
		
}
