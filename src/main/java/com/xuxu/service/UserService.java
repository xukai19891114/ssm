package com.xuxu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuxu.mapper.UserMapper;
import com.xuxu.po.User;
import com.xuxu.po.UserExample;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public List<User> getAll(){
		UserExample example = new UserExample();
		List<User> userList = userMapper.selectByExample(example);
		return userList;
	}
}
