package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String username = req.getParameter("username");
         String password = req.getParameter("password");
         String hobby[] = req.getParameterValues("hobby");
        System.out.println("姓名" + username + "密码" + password + "爱好" + Arrays.asList(hobby));
    }
}
