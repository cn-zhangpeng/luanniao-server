package com.zp95sky.luanniao.softwaretime.controller;

import com.zp95sky.luanniao.common.response.BaseResult;
import com.zp95sky.luanniao.common.response.ResultUtil;
import com.zp95sky.luanniao.softwaretime.dto.BatchReportSoftwareUseTimeDto;
import com.zp95sky.luanniao.softwaretime.service.SoftwareUseTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 软件使用时间统计
 * @author 山海散客
 * @date 2021年06月22日 14:44
 */
@Api(tags = "软件使用统计")
@RestController
@RequestMapping(value = "/software/time")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class SoftwareUseTimeController {

    private final SoftwareUseTimeService softwareUseTimeService;

    @ApiOperation("上报使用记录")
    @PostMapping("/reportRecord/batch")
    public BaseResult<Void> reportRecord(@RequestBody BatchReportSoftwareUseTimeDto softwareUseTimeDto) {
        softwareUseTimeService.batchReportSoftwareUseTime(softwareUseTimeDto);
        return ResultUtil.buildResultSuccess();
    }

}
