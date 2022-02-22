package com.common.biz;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
public class SSOBiz
{

    /**
     * 获取当前请求 header、cookie携带的认证信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    public Map<String, String> getSSOInfo(HttpServletRequest request) throws Exception
    {
        Map<String, String> pkiInfo = new HashMap<>();
        if (request == null)
        {
            return pkiInfo;
        }
        if (request.getCookies() != null)
        {
            for (Cookie cookie : request.getCookies())
            {
                String key = cookie.getName();
                String value = cookie.getValue();
                pkiInfo.put(key, value);
            }
        }
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements())
        {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            value = new String(value.getBytes("ISO8859-1"), "GBK");
            pkiInfo.put(key, value);
        }
        return pkiInfo;
    }
}
