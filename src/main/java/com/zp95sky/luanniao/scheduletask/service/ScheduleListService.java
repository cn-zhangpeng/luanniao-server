package com.zp95sky.luanniao.scheduletask.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zp95sky.luanniao.scheduletask.domain.ScheduleListDo;
import com.zp95sky.luanniao.scheduletask.entity.ScheduleList;

import java.util.List;

/**
 * 日程清单业务处理
 * @author 山海散客
 */
public interface ScheduleListService extends IService<ScheduleList> {

    /**
     * 查询日程清单列表
     * @return 日程清单列表数据
     */
    List<ScheduleListDo> getScheduleList();

}
