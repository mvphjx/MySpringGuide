package com.example.zuul.handler;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

/**
 * 自定义处理类
 */
@Component
public class MyFilter extends ZuulFilter
{
    /**
     * 前处理
     * @return
     */
    @Override
    public String filterType()
    {
        return "pre";
    }

    @Override
    public int filterOrder()
    {
        return 1;
    }

    @Override
    public boolean shouldFilter()
    {
        return true;
    }

    /**
     * 自定义处理，增加Header信息
     * @return
     */
    @Override
    public Object run()
    {
        RequestContext currentContext = RequestContext.getCurrentContext();
        currentContext.addZuulRequestHeader("Zuul-Filter", "11223344");
        return null;
    }
}
