package com.common.ctrl;

import com.common.biz.BeanManager;
import com.common.biz.SSOBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 首页
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/11 22:12
 */
@Controller
@RequestMapping("")
public class HomeCtrl
{
    @Autowired
    private BeanManager beanManager;
    @Autowired
    private SSOBiz ssoBiz;
    @GetMapping(path = { "", "/" })
    public String homePage(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        model.addAttribute("beanData", beanManager.get());
        model.addAttribute("ssoInfo", ssoBiz.getSSOInfo(request));
        return "home";
    }

}
