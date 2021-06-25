package com.zp95sky.luanniao.user.service;

import com.zp95sky.luanniao.annotation.CommonTestAnnotation;
import com.zp95sky.luanniao.user.dto.AddUserDto;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * 用户逻辑测试类
 * @author 山海散客
 * @date 2021年06月25日 14:30
 */
@CommonTestAnnotation
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void addUser() {
        AddUserDto userDto = new AddUserDto();
        userDto.setUsername("luanniao");
        userDto.setPassword("luanniao");
        userDto.setNickname("鸾鸟");
        userService.addUser(userDto);
    }

}
