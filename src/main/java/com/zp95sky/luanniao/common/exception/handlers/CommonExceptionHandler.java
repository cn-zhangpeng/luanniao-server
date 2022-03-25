package com.zp95sky.luanniao.common.exception.handlers;

import com.zp95sky.luanniao.common.constants.ResponseConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用异常处理
 * @author 山海紫穹
 */
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String resolveException(HttpServletRequest request, Exception e) {
        String requestUri = request.getRequestURI();
        log.error(" >>>>>> " + requestUri + " error !", e);
        return ResponseConstant.INTERNAL_SERVER_ERROR;
    }

}
