package com.common.base.exception;

/**
 *业务异常类
 */
public class BizException extends CustomException
{
    private static final long serialVersionUID = -9152774952913597366L;

    /**
     * 构造一个没有错误信息的 <code>RpcException</code>
     */
    public BizException()
    {
        super();
    }

    /**
     * 使用指定的 Throwable 和 Throwable.toString() 作为异常信息来构造 RpcException
     *
     * @param cause 错误原因， 通过 Throwable.getCause() 方法可以获取传入的 cause信息
     */
    public BizException(Throwable cause)
    {
        super(cause);
    }

    /**
     * 使用错误信息 message 构造 RpcException
     *
     * @param message 错误信息
     */
    public BizException(String message)
    {
        super(message);
    }

    /**
     * 使用错误码和错误信息构造 RpcException
     *
     * @param code    错误码
     * @param message 错误信息
     */
    public BizException(String code, String message)
    {
        super(code, message);
    }

    /**
     * 使用错误信息和 Throwable 构造 RpcException
     *
     * @param message 错误信息
     * @param cause   错误原因
     */
    public BizException(String message, Throwable cause)
    {
        super(message, cause);
    }

    /**
     * @param code    错误码
     * @param message 错误信息
     * @param cause   错误原因
     */
    public BizException(String code, String message, Throwable cause)
    {
        super(code, message, cause);
    }

    /**
     * @param errorCode ErrorCode
     */
    public BizException(ErrorCode errorCode)
    {
        super(errorCode);
    }

    /**
     * @param errorCode ErrorCode
     * @param cause     错误原因
     */
    public BizException(ErrorCode errorCode, Throwable cause)
    {
        super(errorCode, cause);
    }
}
