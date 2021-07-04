package com.zp95sky.luanniao.software.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author 山海散客
 * @date 2021年07月02日 14:30
 */
@ApiModel("周统计具体详情")
@Data
public class WeekStatisticUseTimeDo {

    @ApiModelProperty("软件名称")
    private String softwareName;

    @ApiModelProperty("使用时长")
    private List<Integer> useTimeList;

}
