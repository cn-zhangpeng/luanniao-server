package com.zp95sky.luanniao.scheduletask.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.zp95sky.luanniao.scheduletask.entity.ScheduleTask;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 山海紫穹
 */
@ApiModel(value = "UpdateScheduleTaskDto", description = "更新任务信息")
@Data
public class UpdateScheduleTaskDto {

    @ApiModelProperty("任务标题")
    private String title;

    @ApiModelProperty("任务标题")
    private String content;

    @ApiModelProperty("任务时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime taskTime;

    @ApiModelProperty("任务状态")
    private ScheduleTask.TaskStatus taskStatus;

}
