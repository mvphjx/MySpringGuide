package com.common.base.exception;

import com.common.base.result.HttpEnum;
import com.common.base.result.ResponseResult;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 404或者405等错误信息
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/11 23:18
 */

@RestController
public class NotFoundException implements ErrorController
{

    public String getErrorPath()
    {
        return "/error";
    }

    @RequestMapping(value = { "/error" })
    public ResponseResult error(HttpServletRequest request)
    {
        return ResponseResult.failed(HttpEnum.NotFound_400.code(), HttpEnum.NotFound_400.desc());
    }

}
