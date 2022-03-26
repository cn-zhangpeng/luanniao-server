package com.zp95sky.luanniao.scheduletask.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author 山海散客
 */
@ApiModel(value = "ScheduleListDo", description = "日程列表")
@Data
@Builder
public class ScheduleListDo {

    @ApiModelProperty("清单ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty("清单名称")
    private String name;

}
