package com.zp95sky.luanniao.user.service;

import com.zp95sky.luanniao.common.enums.ResponseCodeEnum;
import com.zp95sky.luanniao.user.dto.LoginDto;

/**
 * 登录检测
 * @author 山海散客
 * @date 2021年06月25日 14:21
 */
public interface LoginCheckService {

    /**
     * 登录检测
     * @param loginDto 登录参数
     * @return 检测通过，返回null，否则返回相应错误信息
     */
    ResponseCodeEnum loginCheck(LoginDto loginDto);

}
