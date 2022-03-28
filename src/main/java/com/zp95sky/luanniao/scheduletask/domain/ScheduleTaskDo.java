package com.zp95sky.luanniao.scheduletask.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 山海紫穹
 */
@ApiModel(value = "ScheduleTaskDo", description = "日程任务详情")
@Data
@Builder
public class ScheduleTaskDo {

    @ApiModelProperty("任务标题")
    private String title;

    @ApiModelProperty(value = "清单名称", required = true)
    private String listName;

    @ApiModelProperty("任务内容")
    private String content;

    @ApiModelProperty("任务时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime taskTime;

}
