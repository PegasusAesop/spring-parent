package com.pegasus.springweb.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pegasus.springweb.dao.IUserDao;
import com.pegasus.springweb.domain.User;
import com.pegasus.springweb.mapper.UserMapper;

@Repository("userDao")
public class UserDaoImpl implements IUserDao{

	@Autowired()
	private JdbcTemplate jdbcTemplate;
	
	public User selectByUsername(String username) {

		String sql="select id,username,password from tbl_user where username=?";
		//1查询结果为集合对象;
		List<User> list = jdbcTemplate.query(sql, new Object[] {username},new UserMapper());
		//2查询结果为单个对象；
		//User user = jdbcTemplate.queryForObject(sql, new Object[] {username}, new UserMapper());
		if(null!=list && list.size()>0) {
			
			return list.get(0);
		}
		
		return null;
	}

}
