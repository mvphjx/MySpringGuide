package com.common.dao;

import com.common.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * 用户
 * @author hjx
 * @version 1.0
 * @date 2021/7/14 23:57
 */
@Component
public interface UserDao extends JpaRepository<User,Integer>
{

}
