package com.zp95sky.luanniao.auth.dto;

import com.zp95sky.luanniao.common.constants.ResponseConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author 山海紫穹
 */
@ApiModel("登录参数")
@Data
public class LoginDto {

    @ApiModelProperty("用户名")
    @NotBlank(message = ResponseConstant.USERNAME_IS_NULL)
    private String username;

    @ApiModelProperty("密码")
    @NotBlank(message = ResponseConstant.PASSWORD_IS_NULL)
    private String password;

}
