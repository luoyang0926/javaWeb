package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService=new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"kelai","123","kelai@qq.com"));

    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"kuli","123","kuli@qq.com")));
    }

    @Test
    public void existUsername() {
        if (userService.existUsername("kuli")) {
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名不存在");
        }
    }
}