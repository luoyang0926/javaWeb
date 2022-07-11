package com.atguigu.dao;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    //使用Dbutils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update方法用来执行 Insert/Update/Delete
     * @return
     */
    public int update(String sql,Object...args) {

        Connection connection = JdbcUtils.getConnection();
        try {
           return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

    /**
     * 查询一个的语句
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */


    public <T> T forQueryone(Class<T> type ,String sql,Object...args) {
        Connection connection = JdbcUtils.getConnection();


        try {
           return queryRunner.query(connection,sql,new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回多个javabean的sql语句
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(Class<T> type , String sql, Object...args) {
        Connection connection = JdbcUtils.getConnection();
        try {
           return  queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql
     * @param args
     * @return
     */

    public Object queryForSingleValue(String sql,Object...args) {
        Connection connection = JdbcUtils.getConnection();
        try {
           return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
