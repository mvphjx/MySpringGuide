package com.demo.webflux.flux;

import com.demo.webflux.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hjx
 * @version 1.0
 * @date 2021/7/19 19:49
 */
@RestController
@RequestMapping("/mapping/user")
public class UserCtrl
{

    @GetMapping(path = { "/list" })
    public Flux<User> list()
    {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        return Flux.fromIterable(users);
    }
}
