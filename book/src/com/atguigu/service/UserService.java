package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {


    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);


    /**
     * 判断用户名是否可用
     * @param username
     * @return
     */
    public boolean existUsername(String username);

}
