package com.zp95sky.luanniao.scheduletask.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zp95sky.luanniao.auth.service.LoginService;
import com.zp95sky.luanniao.common.constants.ResponseConstant;
import com.zp95sky.luanniao.scheduletask.domain.ScheduleListDo;
import com.zp95sky.luanniao.scheduletask.dto.AddScheduleListDto;
import com.zp95sky.luanniao.scheduletask.dto.RenameScheduleListDto;
import com.zp95sky.luanniao.scheduletask.entity.ScheduleList;
import com.zp95sky.luanniao.scheduletask.mapper.ScheduleListMapper;
import com.zp95sky.luanniao.scheduletask.service.ScheduleListService;
import com.zp95sky.luanniao.scheduletask.service.ScheduleTaskService;
import io.jsonwebtoken.lang.Assert;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 山海紫穹
 */
@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ScheduleListServiceImpl extends ServiceImpl<ScheduleListMapper, ScheduleList>
        implements ScheduleListService {

    @Resource
    private ScheduleTaskService taskService;

    private final LoginService loginService;

    private final Snowflake snowflake;

    @Override
    public List<ScheduleListDo> getScheduleList() {
        Long userId = loginService.getCurrentUserId();

        List<ScheduleList> scheduleLists =  getScheduleListService(userId);
        return buildScheduleList(scheduleLists);
    }

    @Override
    public void addScheduleList(AddScheduleListDto listDto) {
        Long userId = loginService.getCurrentUserId();

        ScheduleList scheduleList = ScheduleList.builder()
                .id(snowflake.nextId()).name(listDto.getName()).listOrder(0)
                .createTime(LocalDateTime.now()).userId(userId)
                .build();
        save(scheduleList);
    }

    @Override
    public void deleteScheduleList(Long listId) {
        checkUserPermission(listId);

        // 删除清单数据
        removeById(listId);

        // 删除任务数据
        taskService.deleteByListId(listId);
    }

    @Override
    public void renameScheduleList(Long listId, RenameScheduleListDto listDto) {
        checkUserPermission(listId);

        ScheduleList list = ScheduleList.builder()
                .id(listId).name(listDto.getName())
                .build();
        updateById(list);
    }

    @Override
    public void checkUserPermission(Long listId) {
        Long userId = loginService.getCurrentUserId();

        ScheduleList scheduleList = getById(listId);
        Assert.notNull(scheduleList, ResponseConstant.SCHEDULE_LIST_NOT_EXIST);
        Assert.isTrue(scheduleList.getUserId().equals(userId), ResponseConstant.PERMISSION_DENIED);
    }

    private List<ScheduleListDo> buildScheduleList(List<ScheduleList> scheduleLists) {
        if (CollectionUtils.isEmpty(scheduleLists)) {
            return Collections.emptyList();
        }
        return scheduleLists.stream().map(s ->
                ScheduleListDo.builder().id(s.getId()).name(s.getName()).build()
        ).collect(Collectors.toList());
    }

    private List<ScheduleList> getScheduleListService(Long userId) {
        LambdaQueryWrapper<ScheduleList> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ScheduleList::getUserId, userId)
                .orderByAsc(ScheduleList::getListOrder)
                .orderByDesc(ScheduleList::getCreateTime);
        return list(queryWrapper);
    }

}
