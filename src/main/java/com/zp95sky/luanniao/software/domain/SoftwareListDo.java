package com.zp95sky.luanniao.software.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author 山海散客
 * @date 2021年07月01日 13:55
 */
@ApiModel("软件")
@Data
@Builder
public class SoftwareListDo {

    @ApiModelProperty("软件ID")
    private Long id;

    @ApiModelProperty("软件名称")
    private String softwareName;

}
