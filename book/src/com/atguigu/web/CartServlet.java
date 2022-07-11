package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {
    private BookService bookService=new BookServiceImpl();
    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        Cart cart =(Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        req.getSession().setAttribute("lastName", cartItem.getName());
        //重定向回原来商品所在的地址页面
        resp.sendRedirect(req.getHeader("Referer"));
    }
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart =(Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));

        }
    }
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cart cart =(Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        Cart cart =(Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            //修改商品数量
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        Cart cart =(Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        req.getSession().setAttribute("lastName", cartItem.getName());
        //重定向回原来商品所在的地址页面
//        resp.sendRedirect(req.getHeader("Referer"));
        Map<String, Object> map = new HashMap<>();
        map.put("Count ", cart.getTotalCount());
        map.put("lastname", cartItem.getName());
        Gson gson=new Gson();
        String s = gson.toJson(map);
        resp.getWriter().write(s);
    }

}
