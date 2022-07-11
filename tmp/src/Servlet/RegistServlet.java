package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class RegistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session中的验证码
        String attribute = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
       //删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String username = req.getParameter("username");
        String code = req.getParameter("code");
        if (attribute!=null&&code.equalsIgnoreCase(attribute)) {
            System.out.println("登录成功");
              System.out.println("保存到数据库中"+username);
            resp.sendRedirect(req.getContextPath()+"/OK.jsp");
        } else {
            System.out.println("登陆失败");
        }


//        req.getRequestDispatcher("/OK.jsp").forward(req,resp);


    }
}
