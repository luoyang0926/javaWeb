package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.WebConnection;
import java.io.IOException;
import java.io.PrintWriter;

public class PringHtml extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write(" <!DOCTYPE html>\n\r");
        writer.write(" <html lang=\"en\">\n\r");
        writer.write("<html lang=\"en\">\n\r");
        writer.write("<head>\n\r");
        writer.write("<meta charset=\"UTF-8\">\n\r");
        writer.write("<title>Title</title>\n\r");
        writer.write("</head>\n\r");
        writer.write("<body>\n\r");
        writer.write("                这是HTML页面\n\n\r");
        writer.write(" </body>\n\r");
        writer.write("</html>\n\r");




//
//
//
//
//
//
//
//
//
    }
}
