package com.zp95sky.luanniao.user.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zp95sky.luanniao.auth.jwt.JwtConfiguration;
import com.zp95sky.luanniao.auth.jwt.JwtTokenProvider;
import com.zp95sky.luanniao.auth.jwt.UserAuthClaims;
import com.zp95sky.luanniao.common.constants.CommonConstant;
import com.zp95sky.luanniao.user.dto.LoginDto;
import com.zp95sky.luanniao.user.entity.User;
import com.zp95sky.luanniao.user.service.LoginService;
import com.zp95sky.luanniao.user.service.UserService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author 山海紫穹
 * @date 2021年06月25日 13:43
 */
@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class LoginServiceImpl implements LoginService {

    private final HttpServletRequest request;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtConfiguration jwtConfiguration;
    private final Snowflake snowflake;

    private final UserService userService;

    @Override
    public User getLoginUser() {
        String token = getLoginUserToken();
        Claims claims = jwtTokenProvider.parseToken(token);
        return userService.getById(claims.getAudience());
    }

    @Override
    public String login(LoginDto loginDto) {
        // 查询用户
        User user = userService.getByUsername(loginDto.getUsername());

        // 生成token
        return createToken(user);
    }

    private String getLoginUserToken() {
        return request.getHeader(CommonConstant.JWT_HEADER_NAME);
    }

    private String createToken(User user) {
        UserAuthClaims uaClaims = new UserAuthClaims();
        Date curDate = new Date();
        uaClaims.setIssuer(jwtConfiguration.getIss());
        uaClaims.setIssuedAt(curDate);
        uaClaims.setAudience(String.valueOf(user.getUserId()));
        uaClaims.setId(snowflake.nextIdStr());
        uaClaims.setExpiration(DateUtil.offsetMinute(curDate, jwtConfiguration.getExpm()));
        uaClaims.setUserId(user.getUserId());
        uaClaims.setUsername(user.getUsername());
        uaClaims.setSubject(String.valueOf(user.getUserId()));
        uaClaims.setNotBefore(curDate);
        return jwtTokenProvider.createToken(uaClaims);
    }

}
