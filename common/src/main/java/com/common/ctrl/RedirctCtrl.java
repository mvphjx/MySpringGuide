package com.common.ctrl;

import com.common.base.HeaderMapRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    /**
     * 转发
     *
     * @param request
     * @param response
     */
    @GetMapping(path = { "/1" })
    public void fun1(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        response.setHeader("dnname", "CN=XXX 110222209901011234, OU=99, OU=88");
        response.setHeader("Authorization", "123456");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/redirct/info");
        HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(request);
        requestWrapper.addHeader("dnname", "CN=XXX 110222209901011234, OU=99, OU=88");
        requestDispatcher.forward(requestWrapper, response);
    }

    /**
     * 重定向
     *
     * @param request
     * @param response
     */
    @GetMapping(path = { "/2" })
    public void fun2(HttpServletRequest request, HttpServletResponse response)
    {
        response.setHeader("dnname", "CN=XXX 110222209901011234, OU=99, OU=88");
        response.setHeader("Authorization", "123456");
        response.setHeader("cookie", "123456=1");
        response.setHeader("Location", "http://localhost/redirct/info");
        response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
    }

    @GetMapping(path = { "/info" })
    public Object info(HttpServletRequest request, HttpServletResponse response)
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
