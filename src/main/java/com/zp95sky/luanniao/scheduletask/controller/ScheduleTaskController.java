package com.zp95sky.luanniao.scheduletask.controller;

import com.zp95sky.luanniao.common.constants.ResponseConstant;
import com.zp95sky.luanniao.scheduletask.domain.ScheduleTaskDo;
import com.zp95sky.luanniao.scheduletask.domain.ScheduleTaskListDo;
import com.zp95sky.luanniao.scheduletask.dto.AddScheduleTaskDto;
import com.zp95sky.luanniao.scheduletask.dto.UpdateScheduleTaskDto;
import com.zp95sky.luanniao.scheduletask.service.ScheduleTaskService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 山海紫穹
 */
@Api(tags = "日程任务管理")
@RestController
@RequestMapping("/schedule/task")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ScheduleTaskController {

    private final ScheduleTaskService taskService;

    @ApiOperation("查询日程任务列表")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "listId", value = "清单ID", required = true, paramType = "query", dataTypeClass = Long.class),
    })
    public List<ScheduleTaskListDo> getScheduleTask(@RequestParam @NotNull(message = ResponseConstant.SCHEDULE_LIST_ID_IS_NULL) Long listId) {
        return taskService.getScheduleTask(listId);
    }

    @ApiOperation("查询日程任务详情")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "id", value = "任务ID", required = true, paramType = "path", dataTypeClass = String.class)
    public ScheduleTaskDo getScheduleTaskDetail(@PathVariable("id") @NotBlank(message = ResponseConstant.SCHEDULE_LIST_ID_IS_NULL) @NotNull Long taskId) {
        return taskService.getScheduleTaskDetail(taskId);
    }

    @ApiOperation("添加日程任务")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void addScheduleTask(@RequestBody @ApiParam("任务信息") @Valid AddScheduleTaskDto taskDto) {
        taskService.addScheduleTask(taskDto);
    }

    @ApiOperation("删除日程任务")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "id", value = "任务ID", required = true, paramType = "path", dataTypeClass = String.class)
    public void deleteScheduleTask(@PathVariable("id") @NotBlank(message = ResponseConstant.SCHEDULE_LIST_ID_IS_NULL) @NotNull Long taskId) {
        taskService.deleteScheduleTask(taskId);
    }

    @ApiOperation("更新日程任务")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "id", value = "任务ID", required = true, paramType = "path", dataTypeClass = String.class)
    public void updateScheduleTask(@PathVariable("id") @NotBlank(message = ResponseConstant.SCHEDULE_LIST_ID_IS_NULL) @NotNull Long taskId,
                                   @RequestBody @ApiParam("任务信息") @Valid UpdateScheduleTaskDto taskDto) {
        taskService.updateScheduleTask(taskId, taskDto);
    }

}
