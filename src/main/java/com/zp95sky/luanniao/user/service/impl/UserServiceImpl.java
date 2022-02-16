package com.zp95sky.luanniao.user.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zp95sky.luanniao.user.dto.AddUserDto;
import com.zp95sky.luanniao.user.entity.User;
import com.zp95sky.luanniao.user.mapper.UserMapper;
import com.zp95sky.luanniao.user.service.UserService;
import com.zp95sky.luanniao.user.utils.EncryptUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 山海紫穹
 * @date 2021年06月25日 13:40
 */
@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final Snowflake snowflake;

    @Override
    public User getByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        return getOne(queryWrapper);
    }

    @Override
    public void addUser(AddUserDto addUserDto) {
        String password = EncryptUtil.passwordEncrypt(addUserDto.getPassword());
        User user = User.builder()
                .userId(snowflake.nextId())
                .username(addUserDto.getUsername()).password(password)
                .nickname(addUserDto.getNickname()).build();
        save(user);
    }

}
