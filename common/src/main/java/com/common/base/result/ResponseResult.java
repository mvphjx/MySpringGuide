package com.common.base.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 自定义响应的信息主体
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/11 23:04
 */
@Data
public class ResponseResult<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private T data;

    public static <T> ResponseResult<T> ok()
    {
        return restResult(null, HttpEnum.OK_200.code(), HttpEnum.OK_200.desc());
    }

    public static <T> ResponseResult<T> ok(T data)
    {
        return restResult(data, HttpEnum.OK_200.code(), HttpEnum.OK_200.desc());
    }

    public static <T> ResponseResult<T> ok(T data, String msg)
    {
        return restResult(data, HttpEnum.OK_200.code(), msg);
    }

    public static <T> ResponseResult<T> failed()
    {
        return restResult(null, HttpEnum.ERROR_500.code(), HttpEnum.ERROR_500.desc());
    }

    public static <T> ResponseResult<T> failed(String msg)
    {
        return restResult(null, HttpEnum.ERROR_500.code(), msg);
    }

    public static <T> ResponseResult<T> failed(int code, String msg)
    {
        return restResult(null, code, msg);
    }

    public static <T> ResponseResult<T> failed(T data)
    {
        return restResult(data, HttpEnum.ERROR_500.code(), HttpEnum.ERROR_500.desc());
    }

    public static <T> ResponseResult<T> failed(T data, String msg)
    {
        return restResult(data, HttpEnum.ERROR_500.code(), msg);
    }

    private static <T> ResponseResult<T> restResult(T data, int code, String msg)
    {
        ResponseResult<T> apiResult = new ResponseResult<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
