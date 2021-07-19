package com.demo.mybatisplus;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.mybatisplus.entity.User;
import com.demo.mybatisplus.mapper.UserMapper;
import com.demo.mybatisplus.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

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
    @Autowired
    private UserMapper mapper;

    @Test
    public void get()
    {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("phone", "%7%");
        Map<String, Object> userMap = userService.getMap(wrapper);
        printJson(userMap);
    }

    @Test
    public void delete()
    {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "xiaoming");
        userService.remove(queryWrapper);
    }

    @Test
    public void chain()
    {
        BaseMapper<User> baseMapper = userService.getBaseMapper();
        QueryChainWrapper<User> chainWrapper = new QueryChainWrapper<>(baseMapper);
        List<User> users = chainWrapper.like("phone", "%7%").le("id", 10).list();
        printJson(users);
    }

    @Test
    public void saveOrUpdate()
    {
        User user = new User();
        user.setName("小明");
        user.setUsername("xiaoming");
        user.setPassword("1");
        log.info("save");
        userService.saveOrUpdate(user);
        User one = userService.query().eq("username", "xiaoming").list().get(0);
        printJson(one);
        one.setPassword("2");
        log.info("update");
        userService.saveOrUpdate(one);
        List list = userService.query().eq("username", "xiaoming").list();
        printJson(list);
    }

    /**
     * 分页查询
     */
    @Test
    public void queryBySelectPage()
    {
        QueryWrapper<User> param = Wrappers.<User>query().le("id", 10);
        Page<User> mpPage = mapper.selectPage(new Page<>(1, 10), param);
        assertThat(mpPage.getTotal()).isEqualTo(3L);
        List<User> records = mpPage.getRecords();
        assertThat(records).isNotEmpty();
        assertThat(records.size()).isEqualTo(3);
        printJson(records);
    }

    @Test
    public void queryByPageHelper()
    {
        PageHelper.startPage(1, 10);
        Map<String, Object> params = new HashMap<>();
        params.put("id", 10);
        //mybatis xml 实现query
        List<Map<String, Object>> maps =mapper.query(params);
        PageInfo info = new PageInfo<>(maps);
        assertThat(info.getTotal()).isEqualTo(3L);
        List records = info.getList();
        assertThat(records).isNotEmpty();
        assertThat(records.size()).isEqualTo(3);
        printJson(records);
    }

    private void printJson(Object obj)
    {
        JSON json = JSONUtil.parse(obj);
        String str = JSONUtil.toJsonStr(json, 2);
        log.info(str);
    }
}
