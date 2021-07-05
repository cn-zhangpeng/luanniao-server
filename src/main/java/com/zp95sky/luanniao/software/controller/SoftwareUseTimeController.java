package com.zp95sky.luanniao.software.controller;

import com.zp95sky.luanniao.common.response.BaseResult;
import com.zp95sky.luanniao.common.response.ResultUtil;
import com.zp95sky.luanniao.software.domain.WeekStatisticDo;
import com.zp95sky.luanniao.software.domain.YearDateStatisticDo;
import com.zp95sky.luanniao.software.dto.BatchReportSoftwareUseTimeDto;
import com.zp95sky.luanniao.software.service.SoftwareUseTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
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

    @ApiOperation("近一周时间使用量统计")
    @GetMapping("/weekStatistic")
    public BaseResult<WeekStatisticDo> weekStatistic() {
        WeekStatisticDo weekStatisticDo = softwareUseTimeService.weekStatistic();
        return ResultUtil.buildResultSuccess(weekStatisticDo);
    }

    @ApiOperation("本年每天软件的使用时长")
    @GetMapping("/yearDateStatistic")
    public BaseResult<List<YearDateStatisticDo>> yearDateStatistic() {
        List<YearDateStatisticDo> statisticDoList = softwareUseTimeService.yearDateStatistic();
        return ResultUtil.buildResultSuccess(statisticDoList);
    }

}
