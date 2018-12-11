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
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
	
	/*
	 * 批量添加
	 * 前端传入JSON对象数组字符串 后端使用字符串接收
	 * Content-Type=application/json
	 * [{"username":"t1"},{"username":"t2"},{"username":"t3"}]
	 */
	@RequestMapping(value="/users/str",method=RequestMethod.POST)
	public boolean insertBatchByStr(@RequestBody String usersStr){
		JSONArray users = JSONObject.parseArray(usersStr);
		List<UserEntity> userList =users.toJavaList(UserEntity.class);
		return userService.saveBatch(userList);
	}
	
	/*
	 * 批量添加
	 * 前端传入JSON对象数组字符串
	 * Content-Type=application/json
	 * [{"username":"t1"},{"username":"t2"},{"username":"t3"}]
	 */
	@RequestMapping(value="/users/list",method=RequestMethod.POST)
	public boolean insertBatchByList(@RequestBody List<UserEntity> users){
		return userService.saveBatch(users);
	}
	
	/*
	 * 存在更新记录，否插入一条记录 
	 * {"id":113,"username":"saveOrUpdate"}
	 */
	@RequestMapping(value="/users/saveOrUpdate",method=RequestMethod.POST)
	public void saveOrUpdate(@RequestBody UserEntity user){
		userService.saveOrUpdate(user);
	}
	
	/*
	 * 根据条件修改
	 * {"username":"updateTest"}
	 */
	@RequestMapping(value="/users",method=RequestMethod.PUT)
	public void update(@RequestBody UserEntity user){
		UpdateWrapper<UserEntity> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("username", "t1");
		userService.update(user, updateWrapper);
	}
	
	/*
	 *根据ID批量删除
	 *[1,2,3,4] 
	 */
	@RequestMapping(value="/users",method=RequestMethod.DELETE)
	public void delete(@RequestBody List<Integer> idList){
		userService.removeByIds(idList);
	}
	
	/*
	 * 根据条件查询
	 * 
	 */
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<UserEntity> query(){
		QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
		queryWrapper.like(true, "username", "xu");
		return userService.list(queryWrapper);
	}
}
