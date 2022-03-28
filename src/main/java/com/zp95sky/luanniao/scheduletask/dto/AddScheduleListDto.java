package com.zp95sky.luanniao.scheduletask.dto;

import com.zp95sky.luanniao.common.constants.ResponseConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 山海紫穹
 */
@ApiModel(value = "AddScheduleListDto", description = "添加清单信息")
@Data
public class AddScheduleListDto {

    @ApiModelProperty(value = "清单名称", required = true)
    @NotBlank(message = ResponseConstant.SCHEDULE_LIST_NAME_IS_NULL)
    private String name;

}
