package com.common.ctrl;

import cn.hutool.http.ContentType;
import cn.hutool.http.HttpUtil;
import com.common.base.HeaderMapRequestWrapper;
import com.common.biz.SSOBiz;
import com.sun.net.httpserver.HttpExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 模拟单点登录
 */
@Controller
@RequestMapping("/sso")
@Slf4j
public class SSOLoginMockCtrl
{

    /**
     * 模拟网关PKI模式
     * 1 访问网关
     * 2 携带用户信息 header/cookie 跳转到   /
     * 3 解析用户信息，单点登录
     * 4 登录成功/失败，后续操作
     *
     * @param type     header\cookie 认证信息存放位置
     * @param info     认证信息内容
     * @param request
     * @param response
     * @return
     */
    @GetMapping(path = { "/mock" })
    public void page(String type, Map info, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
        HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(request);
        requestWrapper.addHeader("sso-info", "CN=XXX 110222209901011234, OU=99, OU=88");
        requestDispatcher.forward(requestWrapper, response);
    }

    public static void main(String[] args)
    {
        HttpUtil.createServer(8888)
                // 返回JSON数据测试
                .addAction("/", (request, response) -> {
                    response.setHeader("dnname", "CN=XXX 110222209901011234, OU=99, OU=88");
                    response.setHeader("Location", "http://localhost/");
                    HttpExchange httpExchange = response.getHttpExchange();
                    response.send(HttpServletResponse.SC_TEMPORARY_REDIRECT);
                }).start();
    }
}
