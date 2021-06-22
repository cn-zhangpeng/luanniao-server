package com.zp95sky.luanniao.common.response;

import com.zp95sky.luanniao.common.enums.ResponseCodeEnum;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * 返回工具类
 * @author 山海散客
 * @date 2021年06月22日 14:02
 */
public class ResultUtil {

    private ResultUtil() { }

    public static <T> BaseResult<T> buildResult(HttpStatus status, String msg, T data) {
        BaseResult<T> result = BaseResult.getInstance();
        result.setStatus(status);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> BaseResult<T> buildResultSuccess(T data) {
        ResponseCodeEnum success = ResponseCodeEnum.OK;
        return buildResult(success.getStatus(), success.getMsg(), data);
    }

    public static <T> BaseResult<T> buildResultSuccess() {
        return buildResultSuccess(null);
    }

    public static <T> BaseResult<T> buildBadRequestResult() {
        ResponseCodeEnum badRequest = ResponseCodeEnum.BAD_REQUEST;
        return buildResult(badRequest.getStatus(), badRequest.getMsg());
    }

    public static <T> BaseResult<T> buildInternalServerErrorResult() {
        ResponseCodeEnum serverError = ResponseCodeEnum.INTERNAL_SERVER_ERROR;
        return buildResult(serverError.getStatus(), serverError.getMsg());
    }

    public static <T> BaseResult<T> buildResult(HttpStatus code, T data) {
        return buildResult(code, null, data);
    }

    public static <T> BaseResult<T> buildResult(HttpStatus code, String msg) {
        return buildResult(code, msg, null);
    }

    public static <T> BaseResult<BasePageResult<T>> buildPageResultSuccess(BasePageResult<T> pageResult) {
        return buildResultSuccess(pageResult);
    }

    public static <T> BaseResult<BasePageResult<T>> buildPageResult(HttpStatus code, String msg, BasePageResult<T> pageResult) {
        return buildResult(code, msg, pageResult);
    }

    public static <T> BaseResult<BasePageResult<T>> buildPageResult(HttpStatus code, BasePageResult<T> pageResult) {
        return buildResult(code, pageResult);
    }

    public static <T> BaseResult<BasePageResult<T>> buildPageResult(HttpStatus code, String msg, Integer page, Integer pageSize, Long total, List<T> dataList) {
        BasePageResult<T> pageResult = BasePageResult.getInstance(page, pageSize, total, dataList);
        return buildResult(code, msg, pageResult);
    }

    public static <T> BaseResult<BasePageResult<T>> buildPageResult(HttpStatus code, Integer page, Integer pageSize, Long total, List<T> dataList) {
        return buildPageResult(code, null, page, pageSize, total, dataList);
    }

    public static <T> BaseResult<BasePageResult<T>> buildPageResultSuccess(Integer page, Integer pageSize, Long total, List<T> dataList) {
        ResponseCodeEnum success = ResponseCodeEnum.OK;
        return buildPageResult(success.getStatus(), success.getMsg(), page, pageSize, total, dataList);
    }

}
