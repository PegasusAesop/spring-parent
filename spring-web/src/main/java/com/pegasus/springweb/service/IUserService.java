package com.pegasus.springweb.service;

import com.pegasus.springweb.domain.User;

public interface IUserService {

	public User login(String username,String password);
}
