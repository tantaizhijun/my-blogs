package com.spring.blogs.myblogs.repository;

import com.spring.blogs.myblogs.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 用户接口的实现类
 * 模拟存储在数据库,,,使用一个final定义的map集合模拟
 */
@Repository
public class UserRepoImpl implements UserRepo {

    private static AtomicLong counter = new AtomicLong();

    private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<Long, User>();

    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if (StringUtils.isEmpty(id) || id <= 0) {
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> getUserList() {
        return new ArrayList<>(this.userMap.values());
    }
}
