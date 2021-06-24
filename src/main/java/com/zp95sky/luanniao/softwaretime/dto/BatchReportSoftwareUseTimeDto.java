package com.zp95sky.luanniao.softwaretime.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author 山海散客
 * @date 2021年06月24日 14:12
 */
@ApiModel("批量上报软件使用时间参数")
@Data
public class BatchReportSoftwareUseTimeDto {

    /** {@link com.zp95sky.luanniao.softwaretime.enums.SoftwareDeviceTypeEnum} */
    @ApiModelProperty("设备类型，pc：电脑端，mobile：移动端")
    private String deviceType;

    @ApiModelProperty("软件使用详情")
    private List<BatchReportSoftwareUseTimeDetailDto> useTimeDetailDtoList;

}
