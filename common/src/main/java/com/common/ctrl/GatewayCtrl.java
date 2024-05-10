package com.common.ctrl;

import com.common.base.result.ResponseResult;
import com.common.biz.BeanManager;
import com.common.data.BeanData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bean容器数据展示
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/11 22:12
 */
@Api(tags = "Gateway测试")
@RestController
@RequestMapping("/gt")
@Slf4j
public class GatewayCtrl
{
    @Autowired
    private BeanManager beanManager;

    @ApiOperation(value = "获取header信息")
    @GetMapping(path = { "/header" })
    public Map header(HttpServletRequest request)
    {
        Map msg = new HashMap();
        msg.put("GatewayCtrl", System.currentTimeMillis());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements())
        {
            String name = headerNames.nextElement();
            msg.put(name, request.getHeader(name));
        }
        return msg;
    }

}
