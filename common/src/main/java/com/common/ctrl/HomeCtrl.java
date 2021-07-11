package com.common.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * @author hjx
 * @version 1.0
 * @date 2021/7/11 22:12
 */
@Controller()
@RequestMapping("")
public class HomeCtrl
{
    @GetMapping(path ={"","/"})
    public String homePage(){
        return "home";
    }

}
