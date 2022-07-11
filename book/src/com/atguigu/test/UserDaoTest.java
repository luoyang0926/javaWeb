package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

public class UserDaoTest {
  UserDao userDao=new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        if (userDao.queryUserByUsername("admin") == null) {
            System.out.println("用户名可用!");
        }else{
            System.out.println("用户名不可用!!!");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("laojiu", "123") == null) {
            System.out.println("用户名或密码错误，登录失败");
        }else{
            System.out.println("登陆成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"andelu","333333","andelu@qq.com")));
    }
}