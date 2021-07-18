package com.demo.mybatisplus.controller;


import com.demo.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author han
 * @since 2021-07-18
 */
@RestController
@RequestMapping("/mp/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = { "", "/" })
    public Object data()
    {
        return userService.list();
    }
}
