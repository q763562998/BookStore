package com.athome.dao;

import com.athome.pojo.Pages;
import com.athome.utils.Jdbc_teach_util;
//import com.athome.utils.Jdbc_utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 修改
     *
     * @param sql
     * @param args
     * @return 修改了多少行数
     */
    public int update(String sql, Object... args) {
        Connection connection = null;
        connection = Jdbc_teach_util.getConnection1();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }

    }

    /**
     * 查询并返回一个javaBean的sql语句
     *
     * @param type 返回对象的类型
     * @param sql  执行的sql语句
     * @param args sql语句里的具体参数
     * @param <T>  返回值类型
     * @return
     */
    public <T> T queryforone(Class<T> type, String sql, Object... args) {
        Connection connection = null;
        connection = Jdbc_teach_util.getConnection1();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }

    }

    public <T> List<T> queryformore(Class<T> type, String sql, Object... args) {
        Connection connection = null;
        connection = Jdbc_teach_util.getConnection1();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }

    }

    /**
     * 返回一行一列的sql
     * @param sql
     * @param args
     * @return
     */
    public Object queryforValue(String sql, Object... args) {
        Connection connection = null;
        connection = Jdbc_teach_util.getConnection1();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }

    }


    public abstract Pages getBookByprice(int min0, int max0, int num, int size);
}
