package com.atguigu.servlet;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet{

    protected void JavaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ajax过来了");
        Person person = new Person(1, "老八");
        Gson gson=new Gson();
        String jsonPersonString = gson.toJson(person);
        resp.getWriter().write(jsonPersonString);

    }
    protected void JqueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JqueryAjax===方法调用了");
        Person person = new Person(1, "老八");
        Gson gson=new Gson();
        String jsonPersonString = gson.toJson(person);
        resp.getWriter().write(jsonPersonString);

    }protected void JqueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JqueryGet===方法调用了");
        Person person = new Person(1, "老八");
        Gson gson=new Gson();
        String jsonPersonString = gson.toJson(person);
        resp.getWriter().write(jsonPersonString);

    }
    protected void JqueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JqueryPost===方法调用了");
        Person person = new Person(1, "老八");
        Gson gson=new Gson();
        String jsonPersonString = gson.toJson(person);
        resp.getWriter().write(jsonPersonString);

    }
    protected void JqueryGetJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JqueryGetJson===方法调用了");
        Person person = new Person(1, "老八");
        Gson gson=new Gson();
        String jsonPersonString = gson.toJson(person);
        resp.getWriter().write(jsonPersonString);

    }
    protected void JquerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JquerySerialize===方法调用了");
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
        Person person = new Person(1, "老八");
        Gson gson=new Gson();
        String jsonPersonString = gson.toJson(person);
        resp.getWriter().write(jsonPersonString);

    }


}
