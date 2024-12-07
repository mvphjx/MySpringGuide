package com.demo.report.extend;

import org.jeecg.modules.jmreport.api.JmReportTokenServiceI;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 按照集成文档要求，实现扩展接口
 * 自定义积木报表鉴权(如果不进行自定义，则所有请求不做权限控制)
 * 1.自定义获取登录token
 * 2.自定义获取登录用户
 */
@Component
public class JimuReportTokenServiceImpl implements JmReportTokenServiceI
{

    /**
     * 通过请求获取Token
     *
     * @param request
     * @return
     */
    @Override
    public String getToken(HttpServletRequest request)
    {
        //System.out.println("---------call---------getToken-----------------------");
        //return TokenUtils.getTokenByRequest(request);
        return "123456";
    }

    /**
     * 自定义获取租户
     *
     * @return
     */
    @Override
    public String getTenantId()
    {
        //        String headerTenantId = null;
        //        HttpServletRequest request = JimuSpringContextUtils.getHttpServletRequest();
        //        if (request != null) {
        //            headerTenantId = request.getHeader(JmConst.HEADER_TENANT_ID);
        //            if(OkConvertUtils.isEmpty(headerTenantId)){
        //                headerTenantId = request.getParameter(JmConst.TENANT_ID);
        //            }
        //        }
        //        return headerTenantId;
        return "1";
    }

    /**
     * 通过Token获取登录人用户名
     *
     * @param token
     * @return
     */
    @Override
    public String getUsername(String token)
    {
        // return JwtUtil.getUsername(token);
        return "admin";
    }

    /**
     * 自定义用户拥有的角色
     *
     * @param token
     * @return
     */
    @Override
    public String[] getRoles(String token)
    {
        return new String[] { "admin" };
    }

    /**
     * Token校验
     *
     * @param token
     * @return
     */
    @Override
    public Boolean verifyToken(String token)
    {
        //System.out.println("---------verify-----Token---------------");
        //return TokenUtils.verifyToken(token, sysBaseAPI, redisUtil);
        return true;
    }

    /**
     * 自定义请求头
     *
     * @return
     */
    @Override
    public HttpHeaders customApiHeader()
    {
        HttpHeaders header = new HttpHeaders();
        header.add("custom-header1", "Please set a custom value 1");
        header.add("token", "token value 2");
        return header;
    }
}
