package com.common.dao;

import com.common.model.Role;
import com.common.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * 角色
 * @author hjx
 * @version 1.0
 * @date 2021/7/14 23:57
 */
@Component
public interface RoleDao extends JpaRepository<Role,Integer>
{

}
