package com.zp95sky.luanniao.scheduletask.controller;

import com.zp95sky.luanniao.common.constants.ResponseConstant;
import com.zp95sky.luanniao.scheduletask.domain.ScheduleListDo;
import com.zp95sky.luanniao.scheduletask.dto.AddScheduleListDto;
import com.zp95sky.luanniao.scheduletask.dto.RenameScheduleListDto;
import com.zp95sky.luanniao.scheduletask.service.ScheduleListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 山海紫穹
 */
@Api(tags = "日程管理")
@RestController
@RequestMapping("/schedule/list")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired}))
public class ScheduleController {

    private final ScheduleListService listService;

    @ApiOperation("查询日程清单列表")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ScheduleListDo> getScheduleList() {
        return listService.getScheduleList();
    }

    @ApiOperation("添加日程清单")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void addScheduleList(@RequestBody @ApiParam("清单信息") @Valid AddScheduleListDto listDto) {
        listService.addScheduleList(listDto);
    }

    @ApiOperation("重命名日程清单")
    @PatchMapping(value = "/{id}/rename", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "id", value = "清单ID", required = true, paramType = "path", dataTypeClass = String.class)
    public void renameScheduleList(@PathVariable("id") @NotBlank(message = ResponseConstant.SCHEDULE_LIST_ID_IS_NULL) @NotNull Long listId,
                                   @RequestBody @ApiParam("清单名称") @Valid RenameScheduleListDto listDto) {
        listService.renameScheduleList(listId, listDto);
    }

    @ApiOperation("删除日程清单")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "id", value = "清单ID", required = true, paramType = "path", dataTypeClass = String.class)
    public void deleteScheduleList(@PathVariable("id") @NotBlank(message = ResponseConstant.SCHEDULE_LIST_ID_IS_NULL) @NotNull Long listId) {
        listService.deleteScheduleList(listId);
    }

}
