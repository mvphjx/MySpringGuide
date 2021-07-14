package com.common.biz;

import com.common.dao.UserDao;
import com.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户相关操作
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/14 22:46
 */
@Service
public class UserBiz
{
    @Autowired
    private UserDao userDao;

    public List<User> getAll()
    {
        return userDao.findAll();
    }
}
