package com.zp95sky.luanniao.user.service.impl;

import com.zp95sky.luanniao.common.enums.ResponseCodeEnum;
import com.zp95sky.luanniao.user.dto.LoginDto;
import com.zp95sky.luanniao.user.entity.User;
import com.zp95sky.luanniao.user.service.LoginCheckService;
import com.zp95sky.luanniao.user.service.UserService;
import com.zp95sky.luanniao.user.utils.EncryptUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author 华夏紫穹
 * @date 2021年06月25日 14:22
 */
@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class LoginCheckServiceImpl implements LoginCheckService {

    private final UserService userService;

    @Override
    public ResponseCodeEnum loginCheck(LoginDto loginDto) {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();

        // 参数格式 错误
        if (ObjectUtils.isEmpty(username) || ObjectUtils.isEmpty(password)) {
            return ResponseCodeEnum.BAD_REQUEST;
        }

        // 检测用户是否存在
        User user = userService.getByUsername(username);
        if (ObjectUtils.isEmpty(user)) {
            return ResponseCodeEnum.ERROR_USERNAME_PASSWORD;
        }

        // 检测密码是否匹配
        if (ObjectUtils.isEmpty(user.getPassword()) || !EncryptUtil.passwordEncrypt(password).equals(user.getPassword())) {
            return ResponseCodeEnum.ERROR_USERNAME_PASSWORD;
        }

        return null;
    }

}
