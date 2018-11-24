package com.spring.blogs.myblogs.repository;

import com.spring.blogs.myblogs.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * user repository 接口
 */
public interface UserRepo extends CrudRepository<User,Long> {
    //使用Spring data JPA提供的接口及实现
}
