package com.zp95sky.luanniao.common.exception.handlers;

import com.zp95sky.luanniao.common.constants.ResponseConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用异常处理
 * @author 山海紫穹
 */
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String msg;
        FieldError fieldError = ex.getBindingResult().getFieldError();
        if (!ObjectUtils.isEmpty(fieldError)) {
            msg = fieldError.getDefaultMessage();
        } else {
            msg = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        }
        log.error("method argument not valid exception, param: {}, message: {}",
                ex.getParameter().getParameterName(), msg);
        return msg;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        log.error("throw missing servlet request parameter exception, message: {}", ex.getMessage());
        return ResponseConstant.BAD_REQUEST;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleIllegalArgumentException(Exception ex) {
        log.error("throw illegal argument exception, message: {}", ex.getMessage());
        return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String resolveException(HttpServletRequest request, Exception e) {
        String requestUri = request.getRequestURI();
        log.error(" >>>>>> " + requestUri + " error !", e);
        return ResponseConstant.INTERNAL_SERVER_ERROR;
    }

}
