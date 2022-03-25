package com.zp95sky.luanniao.auth.controller;

import com.zp95sky.luanniao.auth.dto.LoginDto;
import com.zp95sky.luanniao.auth.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 山海紫穹
 */
@Api(tags = "登录")
@RestController
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class LoginController {

    private final LoginService loginService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        return loginService.login(loginDto);
    }

    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public void logout() {

    }

}
