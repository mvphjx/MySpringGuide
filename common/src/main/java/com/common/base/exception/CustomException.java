package com.common.base.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 自定义异常
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/11 23:20
 */
@Data
public class CustomException extends RuntimeException
{
    private static final long serialVersionUID = 8312907182931723379L;
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误码
     */
    private String msg;

    /**
     * 构造一个没有错误信息的 <code>CustomException</code>
     */
    public CustomException()
    {
        super();
    }

    /**
     * 使用指定的 Throwable 和 Throwable.toString() 作为异常信息来构造 CustomException
     *
     * @param cause 错误原因， 通过 Throwable.getCause() 方法可以获取传入的 cause信息
     */
    public CustomException(Throwable cause)
    {
        super(cause);
    }

    /**
     * 使用错误信息 message 构造 CustomException
     *
     * @param message 错误信息
     */
    public CustomException(String message)
    {
        super(message);
    }

    /**
     * 使用错误码和错误信息构造 CustomException
     *
     * @param code    错误码
     * @param message 错误信息
     */
    public CustomException(String code, String message)
    {
        super(message);
        this.code = code;
    }

    /**
     * 使用错误码和错误信息构造 CustomException
     *
     * @param code    错误码
     * @param message 错误信息
     */
    public CustomException(int code, String message)
    {
        super(message);
        this.code = code + "";
    }

    /**
     * 使用错误信息和 Throwable 构造 CustomException
     *
     * @param message 错误信息
     * @param cause   错误原因
     */
    public CustomException(String message, Throwable cause)
    {
        super(message, cause);
    }

    /**
     * @param code    错误码
     * @param message 错误信息
     * @param cause   错误原因
     */
    public CustomException(String code, String message, Throwable cause)
    {
        super(message, cause);
        this.code = code;
    }

    /**
     * @param errorCode ErrorCode
     */
    public CustomException(ErrorCode errorCode)
    {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    /**
     * @param errorCode ErrorCode
     * @param cause     错误原因
     */
    public CustomException(ErrorCode errorCode, Throwable cause)
    {
        super(errorCode.getMessage(), cause);
        this.code = errorCode.getCode();
    }

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    public String getCode()
    {
        return code;
    }
}
