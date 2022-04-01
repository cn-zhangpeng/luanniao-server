package com.zp95sky.luanniao.scheduletask.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zp95sky.luanniao.scheduletask.domain.ScheduleTaskDo;
import com.zp95sky.luanniao.scheduletask.domain.ScheduleTaskListDo;
import com.zp95sky.luanniao.scheduletask.dto.AddScheduleTaskDto;
import com.zp95sky.luanniao.scheduletask.dto.UpdateScheduleTaskDto;
import com.zp95sky.luanniao.scheduletask.entity.ScheduleTask;

import java.util.List;

/**
 * 日程任务业务处理
 * @author 山海紫穹
 */
public interface ScheduleTaskService extends IService<ScheduleTask> {

    /**
     * 查询日程任务列表
     * @param listId 清单ID
     * @return 任务列表
     */
    List<ScheduleTaskListDo> getScheduleTask(Long listId);

    /**
     * 添加日程任务
     * @param taskDto 任务信息
     */
    void addScheduleTask(AddScheduleTaskDto taskDto);

    /**
     * 删除日程任务
     * @param taskId 任务ID
     */
    void deleteScheduleTask(Long taskId);

    /**
     * 更新日程任务
     * @param taskId 任务ID
     * @param taskDto 任务信息
     */
    void updateScheduleTask(Long taskId, UpdateScheduleTaskDto taskDto);

    /**
     * 查询日程任务详情
     * @param taskId 任务ID
     * @return 任务详情
     */
    ScheduleTaskDo getScheduleTaskDetail(Long taskId);

    /**
     * 根据清单ID删除日程任务
     * @param listId 清单ID
     */
    void deleteByListId(Long listId);

}
