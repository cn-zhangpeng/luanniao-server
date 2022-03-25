package com.zp95sky.luanniao.auth.service.impl;

import com.zp95sky.luanniao.auth.dto.LoginDto;
import com.zp95sky.luanniao.common.constants.ResponseConstant;
import com.zp95sky.luanniao.user.entity.User;
import com.zp95sky.luanniao.auth.service.LoginCheckService;
import com.zp95sky.luanniao.user.service.UserService;
import com.zp95sky.luanniao.common.utils.EncryptUtil;
import io.jsonwebtoken.lang.Assert;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 华夏紫穹
 * @date 2021年06月25日 14:22
 */
@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class LoginCheckServiceImpl implements LoginCheckService {

    private final UserService userService;

    @Override
    public void loginCheck(LoginDto loginDto) {
        // 检测用户是否存在
        User user = userService.getByUsername(loginDto.getUsername());
        Assert.notNull(user, ResponseConstant.USER_NOT_EXIST);

        // 检测密码是否匹配
        Assert.isTrue(EncryptUtil.passwordEncrypt(loginDto.getPassword()).equals(user.getPassword()),
                ResponseConstant.PASSWORD_ERROR);
    }

}
