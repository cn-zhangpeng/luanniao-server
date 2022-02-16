package com.zp95sky.luanniao.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * 通用返回
 * @author 山海紫穹
 * @date 2021年06月22日 14:00
 */
@ApiModel(value = "BaseResult<T> 通用返回格式", description = "通用返回格式")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BaseResult<T> {

    @ApiModelProperty("响应状态")
    private HttpStatus status;

    @ApiModelProperty("提示信息")
    private String msg;

    @ApiModelProperty("请求响应数据")
    private T data;

    private BaseResult() { }

    public static <T> BaseResult<T> getInstance() {
        return new BaseResult<>();
    }

}
