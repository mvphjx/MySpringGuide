package com.demo.mybatisplus.service.impl;

import cn.hutool.core.util.StrUtil;
import com.demo.mybatisplus.entity.User;
import com.demo.mybatisplus.mapper.UserMapper;
import com.demo.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author han
 * @since 2021-07-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public boolean saveOrUpdate(User entity)
    {
        if (entity != null)
        {
            if (StrUtil.isBlankIfStr(entity.getPassword()))
            {
                entity.setPassword(null);
            }
            else
            {
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                String encode = bCryptPasswordEncoder.encode("1");
                entity.setPassword(encode);
            }
        }
        return super.saveOrUpdate(entity);
    }
}
