package com.zp95sky.luanniao.scheduletask.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zp95sky.luanniao.scheduletask.domain.ScheduleListDo;
import com.zp95sky.luanniao.scheduletask.dto.AddScheduleListDto;
import com.zp95sky.luanniao.scheduletask.dto.RenameScheduleListDto;
import com.zp95sky.luanniao.scheduletask.entity.ScheduleList;

import java.util.List;

/**
 * 日程清单业务处理
 * @author 山海紫穹
 */
public interface ScheduleListService extends IService<ScheduleList> {

    /**
     * 查询日程清单列表
     * @return 日程清单列表数据
     */
    List<ScheduleListDo> getScheduleList();

    /**
     * 添加日程清单
     * @param listDto 清单信息
     */
    void addScheduleList(AddScheduleListDto listDto);

    /**
     * 删除日程清单
     * @param listId 清单ID
     */
    void deleteScheduleList(Long listId);

    /**
     * 重命名日程清单
     * @param listId 清单ID
     * @param listDto 清单信息
     */
    void renameScheduleList(Long listId, RenameScheduleListDto listDto);

}
