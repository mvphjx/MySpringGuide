package com.common.biz;

import com.common.base.exception.CustomException;
import com.common.base.result.HttpEnum;
import com.common.dao.RoleDao;
import com.common.dao.UserDao;
import com.common.model.Role;
import com.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 用户相关操作
 *
 * @author hjx
 * @version 1.0
 * @date 2021/7/14 22:46
 */
@Service
public class UserBiz implements UserDetailsService
{
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    public List<User> getAll()
    {
        return userDao.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        return userDao.getUserByUsername(s);
    }

    /**
     * JPA多对多关系维护：
     * 1维护关联/引用关系
     * 2维护引用的实体
     * 结合用户/角色的业务逻辑，只需要维护关联关系，
     * 角色实体交给其他service维护即可
     *
     * 新增{用户信息/角色关联信息}
     * 更新{用户信息/角色关联信息}
     *
     * @param user
     * @return
     */
    @Transactional
    public Integer set(User user)
    {
        Integer id = user.getId();
        if (id == null || id <= 0)
        {
            //新增
            List<Integer> roleIds = user.getRoles().stream().map(Role::getId).collect(Collectors.toList());
            List<Role> roles = roleDao.findAllById(roleIds);
            if (roles.size() != roleIds.size())
            {
                throw new CustomException(HttpEnum.ERROR_600.code(), "角色ID不存在，请先添加角色");
            }
            user.setRoles(roles);
        }
        else
        {
            //更新
            //已经持久化的对象
            User dbUser = userDao.findById(id).orElse(null);
            if (dbUser == null)
            {
                throw new CustomException(HttpEnum.ERROR_600.code(), "用户不存在");
            }
            if (user.getRoles() != null)
            {
                //角色更新
                List<Integer> roleIds = user.getRoles().stream().map(Role::getId).collect(Collectors.toList());
                List<Role> roles = roleDao.findAllById(roleIds);
                if (user.getRoles().size() != roleIds.size())
                {
                    throw new CustomException(HttpEnum.ERROR_600.code(), "角色ID不存在，请先添加角色");
                }
                user.setRoles(roles);
            }
            else
            {
                user.setRoles(dbUser.getRoles());
            }

        }
        return userDao.save(user).getId();
    }
}
