package com.spring.blogs.myblogs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * spring security安全配置类
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**","/js/**","/fonts/**","/index").permitAll()   //都可以访问,不拦截
                .antMatchers("/user/**").hasRole("ADMIN")    //需要角色权限才能访问
                .and()
                .formLogin()        //基于form表单登陆验证
                .loginPage("/login").failureUrl("/login-error");

    }

    /**
     * 认证管理
     * @param auth
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()   //认证信息存于内存中,或存储在数据库
                .withUser("tantan")
                .password("123456")
                .roles("ADMIN");
    }



}
