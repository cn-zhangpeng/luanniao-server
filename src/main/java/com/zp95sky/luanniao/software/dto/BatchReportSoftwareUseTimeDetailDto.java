package com.zp95sky.luanniao.software.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 山海散客
 * @date 2021年06月24日 16:27
 */
@ApiModel("批量添加软件使用统计")
@Data
public class BatchReportSoftwareUseTimeDetailDto {

    @ApiModelProperty("软件ID")
    private Long softwareId;

    @ApiModelProperty("软件使用时间，单位：分钟")
    private Integer useTime;

}