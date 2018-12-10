package com.xuxu.service;

import com.xuxu.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuxu
 * @since 2018-12-10
 */
public interface UserService extends IService<UserEntity> {
	
	 boolean save(UserEntity entity);
}
