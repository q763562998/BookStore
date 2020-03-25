package com.athome.utils;
//
//import com.alibaba.druid.pool.DruidAbstractDataSource;
//import com.alibaba.druid.pool.DruidDataSourceFactory;
//import org.junit.Test;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public class Jdbc_utils  {
//    /**
//     * 用德鲁伊获取数据库连接
//     * @return
//     */
//    public static Connection getConnection(){
//        Connection connection = null;
//        try {
//            InputStream stream = Jdbc_teach_util.class.getClassLoader().getResourceAsStream("ali.properties");
//            Properties properties = new Properties();
//            properties.load(stream);
//            DataSource source = DruidDataSourceFactory.createDataSource(properties);
//            connection = source.getConnection();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//
//    /**
//     * 关闭数据库连接池
//     * @param connection
//     */
////    public static void closeConnection(Connection connection){
////        if (connection!=null) {
////            try {
////                connection.close();
////            } catch (SQLException e) {
////                e.printStackTrace();
////            }
////        }
////    }
////    @Test
////    public  void Test01(){
////        for (int i = 0; i < 15; i++) {
////            Connection connection = getConnection();
////            System.out.println(connection);
////            closeConnection(connection);
////        }
////    }
//    @Test
//    public void getConnection3() throws Exception {
//        InputStream stream = Jdbc_teach_util.class.getClassLoader().getResourceAsStream("ali.properties");
//
//        Properties pros = new Properties();
//        pros.load(stream);
//        DataSource source = DruidDataSourceFactory.createDataSource(pros);
//        Connection connection = source.getConnection();
//        System.out.println(connection);
//    }
//}
