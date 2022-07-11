package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1.构造器方法");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        System.out.println("2 init 初始化方法");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

      HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
       String method = httpServletRequest.getMethod();
       System.out.println(method);
//        System.out.println(" service");
//        System.out.println("3 service 方法");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

        System.out.println("4 .destroy 销毁方法");
    }
}
