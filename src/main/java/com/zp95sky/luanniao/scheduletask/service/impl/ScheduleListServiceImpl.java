package com.zp95sky.luanniao.scheduletask.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zp95sky.luanniao.scheduletask.domain.ScheduleListDo;
import com.zp95sky.luanniao.scheduletask.entity.ScheduleList;
import com.zp95sky.luanniao.scheduletask.mapper.ScheduleListMapper;
import com.zp95sky.luanniao.scheduletask.service.ScheduleListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 山海散客
 */
@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ScheduleListServiceImpl extends ServiceImpl<ScheduleListMapper, ScheduleList>
        implements ScheduleListService {

    @Override
    public List<ScheduleListDo> getScheduleList() {
        List<ScheduleList> scheduleLists =  getScheduleListService();
        return buildScheduleList(scheduleLists);
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
