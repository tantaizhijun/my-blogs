package com.spring.blogs.myblogs.repository;

import com.spring.blogs.myblogs.domain.User;

import java.util.List;

/**
 * user repository 接口
 */
public interface UserRepo {
    /**
     * 新建或修改用户信息
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户byId
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 获取用户ByID
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList();
}
