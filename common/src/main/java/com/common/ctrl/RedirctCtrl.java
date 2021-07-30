package com.common.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试服务器转发
 *
 * @author hjx
 * @version 1.0
 * @date 2021年7月30日17:42:31
 */
@RestController
@RequestMapping("/redirct")
public class RedirctCtrl
{
    @GetMapping(path = { "/1" })
    public void fun1(HttpServletResponse response)
    {
        response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        response.setHeader("Authorization", "123456");
        response.setHeader("cookie", "123456=1");
        response.setHeader("Location", "http://localhost/redirct/2");
    }

    @GetMapping(path = { "/2" })
    public Object fun2(HttpServletRequest request, HttpServletResponse response)
    {
        Map hearder = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements())
        {
            String element = headerNames.nextElement();
            hearder.put(element, request.getHeader(element));
        }
        return hearder;
    }
}
