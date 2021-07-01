package com.zp95sky.luanniao.software.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zp95sky.luanniao.software.dto.BatchReportSoftwareUseTimeDetailDto;
import com.zp95sky.luanniao.software.dto.BatchReportSoftwareUseTimeDto;
import com.zp95sky.luanniao.software.dto.ReportSoftwareUseTimeDto;
import com.zp95sky.luanniao.software.entity.SoftwareUseTime;
import com.zp95sky.luanniao.software.enums.SoftwareDeviceTypeEnum;
import com.zp95sky.luanniao.software.mapper.SoftwareUseTimeMapper;
import com.zp95sky.luanniao.software.service.SoftwareUseTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 山海散客
 * @date 2021年06月23日 14:09
 */
@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class SoftwareUseTimeServiceImpl extends ServiceImpl<SoftwareUseTimeMapper, SoftwareUseTime>
        implements SoftwareUseTimeService {

    private final Snowflake snowflake;

    @Override
    public void reportSoftwareUseTime(ReportSoftwareUseTimeDto useTimeDto) {
        SoftwareDeviceTypeEnum deviceTypeEnum = SoftwareDeviceTypeEnum.getByKey(useTimeDto.getDeviceType());
        SoftwareUseTime softwareUseTime = constructSoftwareUseTime(useTimeDto.getSoftwareId(),
                deviceTypeEnum, useTimeDto.getUseTime());
        save(softwareUseTime);
    }

    @Override
    public void batchReportSoftwareUseTime(BatchReportSoftwareUseTimeDto userTimeDto) {
        List<BatchReportSoftwareUseTimeDetailDto> useTimeDtoList = userTimeDto.getUseTimeDetailDtoList();
        List<SoftwareUseTime> softwareUseTimeList = new ArrayList<>(useTimeDtoList.size());
        for (BatchReportSoftwareUseTimeDetailDto utDto : useTimeDtoList) {
            SoftwareDeviceTypeEnum dtEnum = SoftwareDeviceTypeEnum.getByKey(userTimeDto.getDeviceType());
            softwareUseTimeList.add(constructSoftwareUseTime(utDto.getSoftwareId(), dtEnum, utDto.getUseTime()));
        }
        saveBatch(softwareUseTimeList);
    }

    private SoftwareUseTime constructSoftwareUseTime(Long softwareId, SoftwareDeviceTypeEnum deviceTypeEnum,
                                                     Integer useTime) {
        String deviceType = ObjectUtils.isEmpty(deviceTypeEnum) ? "" : deviceTypeEnum.getKey();
        return SoftwareUseTime.builder()
                .id(snowflake.nextId()).softwareId(softwareId).deviceType(deviceType)
                .currentDate(LocalDate.now()).useTimeLength(useTime)
                .build();
    }

}
