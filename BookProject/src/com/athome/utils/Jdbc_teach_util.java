package com.athome.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Jdbc_teach_util {
    private static DruidDataSource dataSource;
    private  static ThreadLocal<Connection> conns=new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            // 读取 jdbc.properties属性配置文件
            InputStream inputStream = Jdbc_teach_util.class.getClassLoader().getResourceAsStream("ali.properties");
            // 从流中加载数据
            properties.load(inputStream);
            // 创建 数据库连接 池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    /**
     * 获取数据库连接池中的连接
     * @return 如果返回null,说明获取连接失败<br/>有值就是获取连接成功
     */
    public static Connection getConnection1(){

        Connection connection=conns.get();
        if (connection==null){
            try {
                connection=dataSource.getConnection();
                conns.set(connection);
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
                throw  new RuntimeException(e);
            }
        }
        return connection;
    }

//    /**
//     * 关闭连接，放回数据库连接池
//     * @param conn
//     */
//    public static void close(Connection conn){
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public static void commitAndClose(){
        Connection connection=conns.get();
        if (connection!=null){


            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                throw  new RuntimeException(e);
            }


             finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw  new RuntimeException(e);
                }
            }

        }
        conns.remove();
    }

    public static void rollbackAndClose(){
        Connection connection=conns.get();
        if (connection!=null){


            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
                throw  new RuntimeException(e);
            }


            finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw  new RuntimeException(e);
                }
            }

        }
        conns.remove();
    }

}
