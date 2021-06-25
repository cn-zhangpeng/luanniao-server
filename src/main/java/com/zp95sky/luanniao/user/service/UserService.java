package com.zp95sky.luanniao.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zp95sky.luanniao.user.dto.AddUserDto;
import com.zp95sky.luanniao.user.entity.User;

/**
 * 用户业务处理
 * @author 山海散客
 * @date 2021年06月25日 13:38
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    User getByUsername(String username);

    /**
     * 添加用户
     * @param addUserDto 用户信息
     */
    void addUser(AddUserDto addUserDto);

}
