package com.zp95sky.luanniao.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 错误码
 * @author 山海散客
 * @date 2021年06月22日 13:56
 */
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum {

    /**
     * 常用错误码
     */
    OK(HttpStatus.OK, "成功！"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "参数错误！"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "发生未知错误，请联系管理员！");

    private final HttpStatus status;
    private final String msg;

}
