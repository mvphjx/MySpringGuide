package com.common.ctrl;

import com.common.base.exception.CustomException;
import com.common.base.result.HttpEnum;
import com.common.base.result.ResponseResult;
import com.common.biz.RoleBiz;
import com.common.biz.UserBiz;
import com.common.model.Role;
import com.common.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    private RoleBiz roleBiz;

    @ApiOperation(value = "获取全部用户")
    @GetMapping(path = { "", "/" })
    public ResponseResult data()
    {
        return ResponseResult.ok(userBiz.getAll());
    }

    @ApiOperation(value = "新增/更新用户")
    @PostMapping(path = { "set", "set/" })
    public ResponseResult set(@RequestBody User user)
    {
        assertUser(user);
        return ResponseResult.ok(userBiz.set(user));
    }

    @ApiOperation(value = "新增/更新角色")
    @PostMapping(path = { "/role/set", "/role/set/" })
    public ResponseResult role(@RequestBody Role role)
    {
        return ResponseResult.ok(roleBiz.set(role));
    }

    /**
     * 参数校验
     *
     * @param user
     */
    private void assertUser(User user)
    {
        if (user == null)
        {
            throw new CustomException(HttpEnum.ERROR_600.code(), HttpEnum.ERROR_600.desc());
        }
        if (user.getId() == null && user.getRoles() == null)
        {
            throw new CustomException(HttpEnum.ERROR_600.code(), "新增时需要填写角色信息");
        }
    }

}
