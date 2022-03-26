package com.zp95sky.luanniao.scheduletask.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 日程清单
 * @author 山海紫穹
 */
@TableName("schedule_list")
@Data
@Builder
public class ScheduleList {

    /** 清单ID */
    @TableId
    private Long id;

    /** 清单名称 */
    @TableField("name")
    private String name;

    /** 清单顺序 */
    @TableField("list_order")
    private Integer listOrder;

    /** 创建时间 */
    @TableField("create_time")
    private LocalDateTime createTime;

}
