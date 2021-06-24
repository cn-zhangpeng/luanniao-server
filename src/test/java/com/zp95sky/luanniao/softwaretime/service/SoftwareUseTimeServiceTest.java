package com.zp95sky.luanniao.softwaretime.service;

import com.zp95sky.luanniao.annotation.CommonTestAnnotation;
import com.zp95sky.luanniao.softwaretime.dto.BatchReportSoftwareUseTimeDetailDto;
import com.zp95sky.luanniao.softwaretime.dto.BatchReportSoftwareUseTimeDto;
import com.zp95sky.luanniao.softwaretime.enums.SoftwareDeviceTypeEnum;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 软件使用时间业务处理
 * @author 山海散客
 * @date 2021年06月24日 16:57
 */
@CommonTestAnnotation
public class SoftwareUseTimeServiceTest {

    @Resource
    private SoftwareUseTimeService useTimeService;

    @Test
    public void testBatchReportSoftwareUseTime() {
        Map<Long, Integer> params = new HashMap<Long, Integer>() {{
            put(1407990753380143104L, 299); //IDEA
            put(1407990753380143105L, 86); // Google Chrome
            put(1407990753380143106L, 41); // WeChat
            put(1407990753380143107L, 23); // 腾讯QQ
            put(1407990753380143108L, 7); // Postman
            put(1407990753380143109L, 6); // Xshell
            put(1407990753380143110L, 5); // 有道云笔记
            put(1407990753380143111L, 5); // 企业微信
            put(1407990753380143112L, 5); // WPS Office
        }};
        BatchReportSoftwareUseTimeDto useTimeDto = constructBatchSoftwareUseTimeDto(params);
        useTimeService.batchReportSoftwareUseTime(useTimeDto);
    }

    private BatchReportSoftwareUseTimeDto constructBatchSoftwareUseTimeDto(Map<Long, Integer> params) {
        String deviceType = SoftwareDeviceTypeEnum.PC.getKey();
        List<BatchReportSoftwareUseTimeDetailDto> detailDtoList = new ArrayList<>(params.keySet().size());
        params.forEach((k, v) -> {
            BatchReportSoftwareUseTimeDetailDto detailDto = new BatchReportSoftwareUseTimeDetailDto();
            detailDto.setSoftwareId(k);
            detailDto.setUseTime(v);
            detailDtoList.add(detailDto);
        });

        BatchReportSoftwareUseTimeDto useTimeDto = new BatchReportSoftwareUseTimeDto();
        useTimeDto.setDeviceType(deviceType);
        useTimeDto.setUseTimeDetailDtoList(detailDtoList);
        return useTimeDto;
    }

}
