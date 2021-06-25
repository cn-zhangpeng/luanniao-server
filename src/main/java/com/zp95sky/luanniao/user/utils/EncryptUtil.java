package com.zp95sky.luanniao.user.utils;

import org.springframework.util.DigestUtils;

/**
 * 加密工具类
 * @author 山海散客
 * @date 2021年06月25日 14:28
 */
public class EncryptUtil {

    private EncryptUtil() { }

    /**
     * 密码加密算法
     * @param password 原始密码
     * @return 加密后的密码
     */
    public static String passwordEncrypt(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

}
