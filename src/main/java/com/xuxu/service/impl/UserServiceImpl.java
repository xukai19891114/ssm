package com.xuxu.service.impl;

import com.xuxu.entity.UserEntity;
import com.xuxu.mapper.UserMapper;
import com.xuxu.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuxu
 * @since 2018-12-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
	@Autowired
	private UserMapper userMapper;
	public boolean save(UserEntity entity){
		System.out.println("业务操作");
		int result = userMapper.insert(entity);
		if(result>0){
			return true;
		}
		return false;
	}
}
