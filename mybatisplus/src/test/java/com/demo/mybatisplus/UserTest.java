package com.demo.mybatisplus;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.demo.mybatisplus.entity.User;
import com.demo.mybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * mp测试
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/18 18:09
 */
@SpringBootTest
public class UserTest
{
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void get()
    {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("phone","%7%");
        Map<String, Object> userMap = userService.getMap(wrapper);
        JSON json = JSONUtil.parse(userMap);
        String userStr = JSONUtil.toJsonStr(json, 2);
        log.info(userStr);
    }

    @Test
    public void chain()
    {
        BaseMapper<User> baseMapper = userService.getBaseMapper();
        QueryChainWrapper<User> chainWrapper = new QueryChainWrapper<>(baseMapper);
        List<User> users = chainWrapper.like("phone", "%7%").list();
        JSON json = JSONUtil.parse(users);
        String userStr = JSONUtil.toJsonStr(json, 2);
        log.info(userStr);
    }
}
