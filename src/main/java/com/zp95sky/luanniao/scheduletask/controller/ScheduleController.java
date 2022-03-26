package com.zp95sky.luanniao.scheduletask.controller;

import com.zp95sky.luanniao.scheduletask.domain.ScheduleListDo;
import com.zp95sky.luanniao.scheduletask.service.ScheduleListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 山海散客
 */
@Api(tags = "日程管理")
@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ScheduleController {

    private final ScheduleListService listService;

    @ApiOperation("查询日程清单列表")
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ScheduleListDo> getScheduleList() {
        return listService.getScheduleList();
    }

}
