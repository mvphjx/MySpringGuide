package com.common.biz;

import com.common.dao.RoleDao;
import com.common.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 角色管理
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/17 16:07
 */
@Service
public class RoleBiz
{
    @Autowired
    private RoleDao roleDao;

    public Integer set(Role role)
    {
        return roleDao.save(role).getId();
    }
}
