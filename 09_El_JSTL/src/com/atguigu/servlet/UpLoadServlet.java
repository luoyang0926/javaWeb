package com.atguigu.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UpLoadServlet extends HttpServlet {
    /**
     * 用来处理上传的数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        ServletInputStream inputStream=req.getInputStream();
//        byte[] bytes = new byte[1024];
//
//        int len=inputStream.read(bytes);
//        System.out.println(new String(bytes, 0, len));

        // 先判断上传的数据是否为多段数据（只有多段的数据，才是文件上传的)
        if (ServletFileUpload.isMultipartContent(req)) {

            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            // 解析上传的数据，得到每一个表单项FileItem
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        //普通表单项
                        System.out.println("表单项的name属性值"+fileItem.getFieldName());
                        //参数UTF-8，解决乱码问题
                        System.out.println("表单项的value属性值"+fileItem.getString("UTF-8"));

                    }else{
                        // 上传的文件
                        System.out.println("表单项的name属性值"+fileItem.getFieldName());
                        System.out.println("上传的文件名"+fileItem.getName());
                        fileItem.write(new File("d:\\"+fileItem.getName()));

                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
