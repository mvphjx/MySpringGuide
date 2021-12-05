package com.common.ctrl;

import com.common.biz.RoleBiz;
import com.common.biz.UserBiz;
import com.common.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报表数据测试
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/15 0:00
 */
@Api(tags = "报表数据测试")
@RestController
@RequestMapping("/report")
public class ReportCtrl
{
    @Autowired
    private UserBiz userBiz;
    @Autowired
    private RoleBiz roleBiz;

    @ApiOperation(value = "获取全部用户")
    @GetMapping(path = { "/user" })
    public Map data()
    {
        List<User> users = userBiz.getAll();
        users.forEach(user -> user.setRoles(null));
        Map result = new HashMap();
        result.put("data", users);
        //当前版本 有bug 必须加入links 不然解析json报错
        result.put("links", "[]");
        return result;
    }

}
