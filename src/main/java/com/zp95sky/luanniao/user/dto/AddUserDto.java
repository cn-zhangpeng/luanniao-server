package com.zp95sky.luanniao.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 山海散客
 * @date 2021年06月25日 14:35
 */
@ApiModel("登录参数")
@Data
public class AddUserDto {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nickname;

}
