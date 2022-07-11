package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponceIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println(resp.getCharacterEncoding());//默认ISO-8859-1
//        // 设置服务器字符集为UTF-8
//        resp.setCharacterEncoding("UTF-8");
//        // 通过响应头设置浏览器也是用字符集UTF-8
       // resp.setHeader("Content-Type","text/html; Charset=UTF-8");

        // 同时设置浏览器和服务器用UTF-8字符集
        resp.setContentType("text/html; charset=UTF-8");
        System.out.println(resp.getCharacterEncoding());//默认ISO-8859-1

        PrintWriter writer = resp.getWriter();
        writer.write("很帅");
    }
}
