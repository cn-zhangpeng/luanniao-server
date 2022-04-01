package com.zp95sky.luanniao.scheduletask.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 日程任务
 * @author 山海紫穹
 */
@TableName("schedule_task")
@Data
@Builder
public class ScheduleTask {

    /** 任务ID */
    @TableId
    private Long id;

    /** 日程清单ID */
    @TableField("list_id")
    private Long listId;

    /** 日程标题 */
    @TableField("title")
    private String title;

    /** 日程内容 */
    @TableField("content")
    private String content;

    /** 任务时间 */
    @TableField("task_time")
    private LocalDateTime taskTime;

    /** 任务状态 */
    @TableField("task_status")
    private TaskStatus taskStatus;

    /** 用户ID */
    @TableField("user_id")
    private Long userId;

    /** 创建时间 */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 任务状态
     */
    @Getter
    @AllArgsConstructor
    public enum TaskStatus {
        UNDONE,
        COMPLETED
    }

}
