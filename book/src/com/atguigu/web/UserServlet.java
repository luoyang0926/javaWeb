package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService=new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //实现登录功能
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            System.out.println("用户名或密码错误");

            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);


            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            System.out.println("登陆成功");
            req.getSession().setAttribute("user",loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }

    }
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //实现注册功能
        String attribute = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //1. 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email    = req.getParameter("email");
        String code    = req.getParameter("code");

        User user =(User) WebUtils.copyParamToBean(req.getParameterMap(), new User());


        //2. 检查 验证码是否正确 ====写死 ，要求验证码为abcde
        if (attribute!=null&&code.equalsIgnoreCase(attribute)) {
            //正确
            // 3.检查 用户名是否可用

            if (userService.existUsername(username)) {

                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                // 不可用
                System.out.println("用户名["+username+"]已存在");
                // 跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);

            }else{
                // 可用
                // 调用service保存到数据库
                userService.registUser(new User(null,username,password,email));
                // 跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }

        }else{

            // 不正确
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            // 跳回注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);

        }
    }
    protected void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());

    }
    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean b = userService.existUsername(username);
        Map<String, Object> result = new HashMap<>();
        result.put("existUsername", b);
        Gson gson=new Gson();
        String json = gson.toJson(result);
        resp.getWriter().write(json);

    }

}
