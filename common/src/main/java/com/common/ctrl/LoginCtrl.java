package com.common.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录页
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/11 22:12
 */
@Controller
@RequestMapping("/login")
public class LoginCtrl
{
    @GetMapping(path = { "", "/" })
    public String page()
    {
        return "login";
    }

}
