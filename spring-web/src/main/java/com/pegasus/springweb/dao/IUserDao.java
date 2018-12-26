package com.pegasus.springweb.dao;

import com.pegasus.springweb.domain.User;

public interface IUserDao {

	public User selectByUsername(String username);
}
