package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {


   private  static DruidDataSource dataSource;
   private static ThreadLocal<Connection> coons=new ThreadLocal<Connection>();

    static {
        try {

            //读取jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            //从流中加载数据
            Properties properties=new Properties();
            properties.load(inputStream);
            //创建数据库连接池
            dataSource =(DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
          //  System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }





    /**
     * 获取数据库中连接池的连接
     *
     * @return
     */
    public static Connection getConnection() {
//
//        Connection coon=null;
//        try {
//            coon=dataSource.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return  coon;
        Connection coon = coons.get();
        if (coon == null) {
            try {
                coon=dataSource.getConnection();
                coons.set(coon);//保存到ThreadLocal对象中，供后面的jdbc操作使用。
                coon.setAutoCommit(false);//设置为手动管理事务

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return coon;
    }

    /**
     * 提交事务，并关闭连接
     */
    public static void commitAndClose() {
        Connection connection=coons.get();
        if (connection != null) {//如果不等于空，说明以前使用过连接，操作过数据库
            try {
                connection.commit();//提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();//关闭连接资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }
        //一定要执行remove操作，否则就会出错。(因为tomcat服务器底层使用了线程池技术)
        coons.remove();
    }
     /**
     * 回滚事务，并关闭连接
     */
    public static void rollbackAndClose() {
        Connection connection=coons.get();
        if (connection != null) {//如果不等于空，说明以前使用过连接，操作过数据库
            try {
                connection.rollback();//回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();//关闭连接资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }
        //一定要执行remove操作，否则就会出错。(因为tomcat服务器底层使用了线程池技术)
        coons.remove();

    }

    //
//    /**
//     * 关闭连接，放回数据库连接池
//     * @param coon
//     */
//    public static void close(Connection coon) {
//        if (coon != null) {
//            try {
//                coon.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

}
