package com.demo.mybatisplus.service.impl;

import com.demo.mybatisplus.entity.User;
import com.demo.mybatisplus.mapper.UserMapper;
import com.demo.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
