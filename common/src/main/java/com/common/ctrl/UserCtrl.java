package com.common.ctrl;

import com.common.base.result.ResponseResult;
import com.common.biz.UserBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/15 0:00
 */
@Api(value = "用户")
@RestController
@RequestMapping("/user")
public class UserCtrl
{
    @Autowired
    private UserBiz userBiz;

    @ApiOperation(value = "获取全部用户")
    @GetMapping(path = { "", "/" })
    public ResponseResult data()
    {
        return ResponseResult.ok(userBiz.getAll());
    }
}
