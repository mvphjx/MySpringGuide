package com.common.ctrl;

import com.common.biz.BeanManager;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping(path = { "", "/" })
    public String homePage(Model model)
    {
        model.addAttribute("beanData", beanManager.get());
        return "home";
    }

}
