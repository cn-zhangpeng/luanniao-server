package com.zp95sky.luanniao.auth.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zp95sky.luanniao.common.constants.CommonConstant;
import com.zp95sky.luanniao.common.enums.ResponseCodeEnum;
import com.zp95sky.luanniao.common.response.BaseResult;
import com.zp95sky.luanniao.common.response.ResultUtil;
import com.zp95sky.luanniao.user.entity.User;
import com.zp95sky.luanniao.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

/**
 * Jwt 过滤器
 * @author 山海散客
 * @date 2021年06月25日 12:49
 */
@WebFilter(urlPatterns = "/*")
@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class JwtFilter implements Filter {

    private final String CONTEXT_PATH = "/luanniao";

    /** 不需要登录认证的接口 */
    private final List<String> WHITE_LIST = Collections.singletonList(
            CONTEXT_PATH + "/login"
    );

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;
    private final LoginService loginService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // 无需校验
        if (WHITE_LIST.contains(httpServletRequest.getRequestURI())) {
            chain.doFilter(request, response);
            return;
        }

        // token 格式校验
        String token = httpServletRequest.getHeader(CommonConstant.JWT_HEADER_NAME);
        if (ObjectUtils.isEmpty(token)) {
            authFailed(httpServletResponse);
            return;
        }

        // 登录校验
        if (!isAuthSuccess(token)) {
            authFailed(httpServletResponse);
            return;
        }

        chain.doFilter(request, response);
    }

    private boolean isAuthSuccess(String token) {
        if (!isTokenValid(token)) {
            return false;
        }

        return userIsExist();
    }

    private boolean isTokenValid(String token) {
        return jwtTokenProvider.parseToken(token) != null;
    }

    private boolean userIsExist() {
        User user = loginService.getLoginUser();
        return !ObjectUtils.isEmpty(user);
    }

    private void authFailed(HttpServletResponse response) {
        ResponseCodeEnum codeEnum = ResponseCodeEnum.ERROR_AUTH_INVALID;
        BaseResult<Void> res = ResultUtil.buildResult(codeEnum.getStatus(), codeEnum.getMsg());
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try (PrintWriter writer = response.getWriter()) {
            String resStr = objectMapper.writeValueAsString(res);
            writer.print(resStr);
        } catch (IOException e) {
            log.error("response error", e);
        }
    }

}
