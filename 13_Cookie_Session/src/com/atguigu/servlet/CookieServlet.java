package com.atguigu.servlet;

import cookieUtil.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 创建cookie
        Cookie cookie = new Cookie("key1", "value1");

        resp.addCookie(cookie);

        resp.getWriter().write("cookie创建成功");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().write("cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br/>");

            Cookie iwantCookie = CookieUtils.findCookie("key1", cookies);
            if (iwantCookie != null) {
                resp.getWriter().write("找到了");

            }

        }

    }
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //方案一:
        // 1 先创建一个要修改的同名的cookie对象
        // 2 在构造器，同时赋予心的cookie值
//        Cookie cookie = new Cookie("key1", "newValue1");
        // 3 调用response.addCookies(cookie)
//        resp.addCookie(cookie);
        //方案二：
        //1.先查找到需要修改的cookie对象
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if (cookie != null) {
            //2.调用setValue()方法赋予新的cookie
                cookie.setValue("newValue2");
            //3.调用resp.addCookies(cookie)通知保存修改
            resp.addCookie(cookie);
        }
    }
    //cookie的控制时间
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife", "defaultLife1");
        cookie.setMaxAge(-1);//设置存活时间
        resp.addCookie(cookie);
    }








}


