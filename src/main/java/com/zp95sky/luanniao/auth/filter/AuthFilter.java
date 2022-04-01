package com.zp95sky.luanniao.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zp95sky.luanniao.common.constants.CommonConstant;
import com.zp95sky.luanniao.common.constants.ResponseConstant;
import com.zp95sky.luanniao.user.entity.User;
import com.zp95sky.luanniao.auth.service.LoginService;
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
 * 登录过滤器
 * @author 山海紫穹
 */
@WebFilter(urlPatterns = "/*")
@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class AuthFilter implements Filter {

    private final String CONTEXT_PATH = "/luanniao";

    /** 不需要登录认证的接口 */
    private final List<String> WHITE_LIST = Collections.singletonList(
            CONTEXT_PATH + "/login"
    );

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
        String token = httpServletRequest.getHeader(CommonConstant.TOKEN_HEADER_NAME);
        if (ObjectUtils.isEmpty(token)) {
            authFailed(httpServletResponse);
            return;
        }

        // 登录校验
        if (!userIsExist()) {
            authFailed(httpServletResponse);
            return;
        }

        chain.doFilter(request, response);
    }

    private boolean userIsExist() {
        User user = loginService.getLoginUser();
        return !ObjectUtils.isEmpty(user);
    }

    private void authFailed(HttpServletResponse response) {
        String result = ResponseConstant.ERROR_AUTH_INVALID;
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try (PrintWriter writer = response.getWriter()) {
            String resStr = objectMapper.writeValueAsString(result);
            writer.print(resStr);
        } catch (IOException e) {
            log.error("response error", e);
        }
    }

}
