package com.atguigu.servlet;

import cookieUtil.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends BaseServlet{


    protected void dengLu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String name = req.getParameter("username");
        String password = req.getParameter("password");
        if (name.equals("laoba") && password.equals("123456")) {
            System.out.println("登陆成功");
            Cookie cookie = new Cookie("name", name);
            cookie.setMaxAge(60*10);
            resp.addCookie(cookie);

        } else {
            System.out.println("登陆失败");
        }
    }
}
