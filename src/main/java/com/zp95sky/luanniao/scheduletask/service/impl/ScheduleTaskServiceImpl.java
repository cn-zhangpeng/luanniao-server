package com.zp95sky.luanniao.scheduletask.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zp95sky.luanniao.scheduletask.entity.ScheduleTask;
import com.zp95sky.luanniao.scheduletask.mapper.ScheduleTaskMapper;
import com.zp95sky.luanniao.scheduletask.service.ScheduleTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 山海紫穹
 */
@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ScheduleTaskServiceImpl extends ServiceImpl<ScheduleTaskMapper, ScheduleTask>
        implements ScheduleTaskService {



}
