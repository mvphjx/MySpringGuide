package com.common.base.exception;

import lombok.Data;

/**
 * 自定义异常
 * @author hjx
 * @version 1.0
 * @date 2021/7/11 23:20
 */
@Data
public class CustomException extends RuntimeException
{
    private int code;
    private String msg;
}
