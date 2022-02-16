package com.zp95sky.luanniao.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author 山海紫穹
 * @date 2021年06月22日 13:55
 */
@ApiModel(value = "CustomPage 分页信息", description = "分页信息")
@Data
@SuperBuilder
public class CustomPage {

    @ApiModelProperty("当前页")
    private Integer page;

    @ApiModelProperty("查询条数")
    private Integer size;

}
