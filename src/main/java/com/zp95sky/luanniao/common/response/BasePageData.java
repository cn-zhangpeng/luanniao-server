package com.zp95sky.luanniao.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页信息
 * @author 山海紫穹
 */
@ApiModel(value = "BasePageData", description = "分页响应格式")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasePageData<T> {

    @ApiModelProperty("当前页")
    private Integer page;

    @ApiModelProperty("每页条数")
    private Integer size;

    @ApiModelProperty("数据总数")
    private Long total;

    @ApiModelProperty("数据列表")
    private List<T> data;

}
