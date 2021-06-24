package com.zp95sky.luanniao.softwaretime.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 山海散客
 * @date 2021年06月24日 13:34
 */
@ApiModel("添加软件参数")
@Data
public class AddSoftwareDto {

    @ApiModelProperty("软件名称")
    private String softwareName;

}