package com.zp95sky.luanniao.user.controller;

import com.zp95sky.luanniao.common.response.BaseResult;
import com.zp95sky.luanniao.common.response.ResultUtil;
import com.zp95sky.luanniao.user.dto.LoginDto;
import com.zp95sky.luanniao.user.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 山海紫穹
 * @date 2021年06月25日 13:52
 */
@Api(tags = "登录")
@RestController
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class LoginController {

    private final LoginService loginService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public BaseResult<String> login(@RequestBody LoginDto loginDto) {
        String token = loginService.login(loginDto);
        return ResultUtil.buildResultSuccess(token);
    }

    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public BaseResult<Void> logout() {

        return ResultUtil.buildResultSuccess();
    }

}
