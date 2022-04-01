package com.zp95sky.luanniao.auth.service;

import com.zp95sky.luanniao.auth.dto.LoginDto;
import com.zp95sky.luanniao.user.entity.User;

/**
 * 登录业务处理
 * @author 山海紫穹
 */
public interface LoginService {

    /**
     * 获取当前登录用户
     * @return 当前登录用户信息
     */
    User getLoginUser();

    /**
     * 登录处理
     * @param loginDto 登录参数
     * @return 登录成功，返回token，否则返回null
     */
    String login(LoginDto loginDto);

    /**
     * 查询当前登录用户ID
     * @return 用户ID
     */
    Long getCurrentUserId();

}
