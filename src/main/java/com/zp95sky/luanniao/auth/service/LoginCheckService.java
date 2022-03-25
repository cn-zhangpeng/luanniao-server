package com.zp95sky.luanniao.auth.service;

import com.zp95sky.luanniao.auth.dto.LoginDto;

/**
 * 登录检测
 * @author 山海紫穹
 * @date 2021年06月25日 14:21
 */
public interface LoginCheckService {

    /**
     * 登录检测
     * @param loginDto 登录参数
     */
    void loginCheck(LoginDto loginDto);

}
