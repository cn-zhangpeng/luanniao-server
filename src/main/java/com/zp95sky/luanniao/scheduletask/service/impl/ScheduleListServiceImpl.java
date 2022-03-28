package com.zp95sky.luanniao.scheduletask.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zp95sky.luanniao.scheduletask.domain.ScheduleListDo;
import com.zp95sky.luanniao.scheduletask.dto.AddScheduleListDto;
import com.zp95sky.luanniao.scheduletask.dto.RenameScheduleListDto;
import com.zp95sky.luanniao.scheduletask.entity.ScheduleList;
import com.zp95sky.luanniao.scheduletask.mapper.ScheduleListMapper;
import com.zp95sky.luanniao.scheduletask.service.ScheduleListService;
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
public class ScheduleListServiceImpl extends ServiceImpl<ScheduleListMapper, ScheduleList>
        implements ScheduleListService {

    private final Snowflake snowflake;

    @Override
    public List<ScheduleListDo> getScheduleList() {
        List<ScheduleList> scheduleLists =  getScheduleListService();
        return buildScheduleList(scheduleLists);
    }

    @Override
    public void addScheduleList(AddScheduleListDto listDto) {
        ScheduleList scheduleList = ScheduleList.builder()
                .id(snowflake.nextId()).name(listDto.getName())
                .listOrder(0).createTime(LocalDateTime.now())
                .build();
        save(scheduleList);
    }

    @Override
    public void deleteScheduleList(Long listId) {
        removeById(listId);
    }

    @Override
    public void renameScheduleList(Long listId, RenameScheduleListDto listDto) {
        ScheduleList list = ScheduleList.builder()
                .id(listId).name(listDto.getName())
                .build();
        updateById(list);
    }

    private List<ScheduleListDo> buildScheduleList(List<ScheduleList> scheduleLists) {
        if (CollectionUtils.isEmpty(scheduleLists)) {
            return Collections.emptyList();
        }
        return scheduleLists.stream().map(s ->
                ScheduleListDo.builder().id(s.getId()).name(s.getName()).build()
        ).collect(Collectors.toList());
    }

    private List<ScheduleList> getScheduleListService() {
        LambdaQueryWrapper<ScheduleList> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(ScheduleList::getListOrder)
                .orderByDesc(ScheduleList::getCreateTime);
        return list(queryWrapper);
    }

}
