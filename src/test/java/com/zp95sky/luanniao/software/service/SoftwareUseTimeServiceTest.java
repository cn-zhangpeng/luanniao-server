package com.zp95sky.luanniao.software.service;

import com.zp95sky.luanniao.annotation.CommonTestAnnotation;
import com.zp95sky.luanniao.software.dto.BatchReportSoftwareUseTimeDetailDto;
import com.zp95sky.luanniao.software.dto.BatchReportSoftwareUseTimeDto;
import com.zp95sky.luanniao.software.enums.SoftwareDeviceTypeEnum;
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
            put(1407990753380143106L, 96); // WeChat
            put(1407990753380143105L, 90); // Google Chrome
            put(1407990753380143104L, 83); //IDEA
            put(1407990753380143112L, 28); // WPS Office
            put(1409482786942881792L, 26); // WebStorm
            put(1407990753380143109L, 15); // Xshell
            put(1407990753380143108L, 13); // Postman
            put(1408016476153188352L, 4); // 终端
            put(1407990753380143111L, 3); // 企业微信
            put(1409830145539313664L, 3); // Another Redis Desktop Manager
            put(1407990753380143107L, 2); // 腾讯QQ
            put(1409483181429755904L, 1); // Xftp

//            put(1408017039897006081L, 2); // DataGrip
//            put(1408368116253200384L, 1); // Typora
//            put(1408017039897006083L, 1); // Docker
//            put(1408368819264688128L, 4); // 网易邮箱大师
//            put(1407990753380143110L, 3); // 有道云笔记
//            put(1408017039897006080L, 1); // XMind
//            put(1408368472097951744L, 8); // TeamViewer
//            put(1408369150115581952L, 3); // 滴答清单
//            put(1408017039897006082L, 6); // Visual Studio Code
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
