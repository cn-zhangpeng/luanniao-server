package com.zp95sky.luanniao.scheduletask.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 山海紫穹
 */
@ApiModel(value = "AddScheduleTaskDto", description = "添加任务信息")
@Data
public class AddScheduleTaskDto {

    @ApiModelProperty(value = "清单ID", required = true)
    private Long listId;

    @ApiModelProperty("任务标题")
    private String title;

    @ApiModelProperty("任务内容")
    private String content;

    @ApiModelProperty("任务时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime taskTime;

}
