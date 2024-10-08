package com.common.base.exception;

import com.common.base.result.HttpEnum;
import com.common.base.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;
import java.util.List;

/**
 * 统一处理异常
 * @RestControllerAdvice = @ControllerAdvice + @ResponseBody ，
 * 如果有其他的异常需要处理，只需要定义@ExceptionHandler注解的方法处理即可。
 * @author hjx
 * @version 1.0
 * @date 2021/7/11 23:11
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler
{
    /**
     * 全局异常.
     *
     * @param e the e
     * @return ResponseResult
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult exception(Exception e)
    {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        JSONObject errorObject = new JSONObject();
        errorObject.put("errorInfo", e.toString());
        // 如果错误堆栈信息存在
        if (e.getStackTrace().length > 0)
        {
            StackTraceElement element = e.getStackTrace()[0];
            int lineNumber = element.getLineNumber();
            errorObject.put("errorPosition", element + ":" + lineNumber);
        }
        return ResponseResult.failed(errorObject);
    }

    /**
     * 自定义异常处理
     *
     * @param e
     * @return ResponseResult
     */
    @ExceptionHandler({ CustomException.class })
    public ResponseResult customExceptionHandLer(CustomException e)
    {
        return ResponseResult.failed(e.getCode(), e.getMsg());
    }

    /**
     * 处理业务异常
     *
     * @param request 请求参数
     * @param e       异常
     * @return Result
     */
    @ExceptionHandler(value = BizException.class)
    public Object bizExceptionHandler(HttpServletRequest request, BizException e)
    {
        log.warn("业务异常：" + e.getMessage(), e);
        return ResponseResult.failed(e.getCode(), e.getMessage());
    }

    /**
     * 校验异常 Exception
     *
     * @param exception
     * @return ResponseResult
     */
    @ExceptionHandler({ MethodArgumentNotValidException.class, BindException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult bodyValidExceptionHandler(MethodArgumentNotValidException exception)
    {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        String errorMessage = "";
        if (fieldErrors != null && fieldErrors.size() > 0)
        {
            log.warn(fieldErrors.get(0).getDefaultMessage());
            errorMessage = fieldErrors.get(0).getDefaultMessage();
        }
        return ResponseResult.failed(HttpEnum.ERROR_600.code(), errorMessage);
    }
}
