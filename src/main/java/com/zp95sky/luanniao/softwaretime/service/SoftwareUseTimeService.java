package com.zp95sky.luanniao.softwaretime.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zp95sky.luanniao.softwaretime.dto.BatchReportSoftwareUseTimeDto;
import com.zp95sky.luanniao.softwaretime.dto.ReportSoftwareUseTimeDto;
import com.zp95sky.luanniao.softwaretime.entity.SoftwareUseTime;

/**
 * 软件使用时间业务处理
 * @author 山海散客
 * @date 2021年06月23日 14:09
 */
public interface SoftwareUseTimeService extends IService<SoftwareUseTime> {

    /**
     * 上报软件使用时长
     * @param useTimeDto 软件使用时长信息
     */
    void reportSoftwareUseTime(ReportSoftwareUseTimeDto useTimeDto);

    /**
     * 批量上报软件使用时长
     * @param useTimeDto 软件使用时长信息
     */
    void batchReportSoftwareUseTime(BatchReportSoftwareUseTimeDto useTimeDto);

}
