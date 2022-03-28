package com.zp95sky.luanniao.scheduletask.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zp95sky.luanniao.common.constants.ResponseConstant;
import com.zp95sky.luanniao.scheduletask.domain.ScheduleTaskDo;
import com.zp95sky.luanniao.scheduletask.domain.ScheduleTaskListDo;
import com.zp95sky.luanniao.scheduletask.dto.AddScheduleTaskDto;
import com.zp95sky.luanniao.scheduletask.dto.UpdateScheduleTaskDto;
import com.zp95sky.luanniao.scheduletask.entity.ScheduleList;
import com.zp95sky.luanniao.scheduletask.entity.ScheduleTask;
import com.zp95sky.luanniao.scheduletask.mapper.ScheduleTaskMapper;
import com.zp95sky.luanniao.scheduletask.service.ScheduleListService;
import com.zp95sky.luanniao.scheduletask.service.ScheduleTaskService;
import io.jsonwebtoken.lang.Assert;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 山海紫穹
 */
@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ScheduleTaskServiceImpl extends ServiceImpl<ScheduleTaskMapper, ScheduleTask>
        implements ScheduleTaskService {

    private final ScheduleListService listService;

    private final Snowflake snowflake;

    @Override
    public List<ScheduleTaskListDo> getScheduleTask(Long listId) {
        LambdaQueryWrapper<ScheduleTask> queryWrapper = buildListQueryWrapper(listId);
        List<ScheduleTask> taskList = list(queryWrapper);
        return buildScheduleTaskListDo(taskList);
    }

    @Override
    public void addScheduleTask(AddScheduleTaskDto taskDto) {
        ScheduleTask scheduleTask = ScheduleTask.builder()
                .id(snowflake.nextId()).listId(taskDto.getListId()).title(taskDto.getTitle())
                .content(taskDto.getContent()).taskTime(taskDto.getTaskTime())
                .taskStatus(ScheduleTask.TaskStatus.UNDONE).createTime(LocalDateTime.now())
                .build();
        save(scheduleTask);
    }

    @Override
    public void deleteScheduleTask(Long taskId) {
        removeById(taskId);
    }

    @Override
    public void updateScheduleTask(Long taskId, UpdateScheduleTaskDto taskDto) {
        ScheduleTask scheduleTask = ScheduleTask.builder()
                .id(taskId).title(taskDto.getTitle()).content(taskDto.getContent())
                .taskTime(taskDto.getTaskTime()).taskStatus(taskDto.getTaskStatus())
                .build();
        updateById(scheduleTask);
    }

    @Override
    public ScheduleTaskDo getScheduleTaskDetail(Long taskId) {
        ScheduleTask scheduleTask = getById(taskId);
        Assert.notNull(scheduleTask, ResponseConstant.SCHEDULE_TASK_NOT_EXIST);

        ScheduleList scheduleList = listService.getById(scheduleTask.getListId());
        return buildScheduleTaskDo(scheduleList, scheduleTask);
    }

    private ScheduleTaskDo buildScheduleTaskDo(ScheduleList scheduleList, ScheduleTask scheduleTask) {
        return ScheduleTaskDo.builder()
                .title(scheduleTask.getTitle()).listName(scheduleList.getName())
                .content(scheduleTask.getContent()).taskTime(scheduleTask.getTaskTime())
                .build();
    }

    private List<ScheduleTaskListDo> buildScheduleTaskListDo(List<ScheduleTask> taskList) {
        if (CollectionUtils.isEmpty(taskList)) {
            return Collections.emptyList();
        }
        return taskList.stream().map(t -> ScheduleTaskListDo.builder()
                        .id(t.getId()).title(t.getTitle()).taskTime(t.getTaskTime())
                .build()).collect(Collectors.toList());
    }

    private LambdaQueryWrapper<ScheduleTask> buildListQueryWrapper(Long listId) {
        LambdaQueryWrapper<ScheduleTask> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ScheduleTask::getListId, listId)
                .eq(ScheduleTask::getTaskStatus, ScheduleTask.TaskStatus.UNDONE)
                .orderByDesc(ScheduleTask::getTaskTime);
        return queryWrapper;
    }

}
