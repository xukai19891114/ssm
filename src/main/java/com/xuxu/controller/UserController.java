package com.xuxu.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xuxu.entity.UserEntity;
import com.xuxu.service.UserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xuxu
 * @since 2018-12-10
 */
@RestController
@RequestMapping("/user-entity")
public class UserController{
	
	@Autowired
	private UserService userService;
	
	/*
	 * 添加
	 */
	@RequestMapping(method=RequestMethod.POST)
	public boolean insert(@RequestBody UserEntity user){
		return userService.save(user);
	}
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public boolean insertb(@RequestBody String usersStr){
		JSONArray users = JSONObject.parseArray(usersStr);
		List<UserEntity> userList =users.toJavaList(UserEntity.class);
		return userService.saveBatch(userList);
	}
}
