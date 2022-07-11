package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet{


    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取session对象
        HttpSession session = req.getSession();
        //判断session是否为新的
        boolean aNew = session.isNew();
        //获取会话的唯一标识
        String id = session.getId();
        resp.getWriter().write("id为" + id+"<br/>");
        resp.getWriter().write("是否为新的"+aNew+"<br/>");
    }
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("已经存了");





      }
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Object key1 = req.getSession().getAttribute("key1");
        resp.getWriter().write("获取的session值"+key1);

    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("默认时间为:"+maxInactiveInterval);

    }
    protected void Life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("已经设置好了");

    }


}

