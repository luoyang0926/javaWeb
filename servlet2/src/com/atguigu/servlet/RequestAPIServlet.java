package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // i.getRequestURI()   获取请求资源路径
        System.out.println("URI--"+ req.getRequestURI());

        // i.getRequestURL()   获取请求的统一资源定位符（绝对路径）

        System.out.println("URL--"+req.getRequestURL());
        // i.getRemotHost()  获取客户端的ip地址

        System.out.println("获取客户端IP地址"+req.getRemoteHost());
        // i,getHeader()      获取请求头

        System.out.println("获取请求头"+req.getHeader("User-Agent"));
        // 1.getMethod()        获取请求的方式get和post
        System.out.println("方式"+req.getMethod());
    }
}
