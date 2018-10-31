package com.jonas.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Desc：JDBC工具类
 * Author Jonas
 * 2018/10/30 14:43
 */
public class JDBCUtils {

    /**
     * 获取Connection
     * @return 所获得到的JDBC的Connection
     */
    public static Connection getConnection() throws Exception {

        /**
         * 不建议把配置硬编码到代码中
         *
         * 最佳实践：配置的建议写到配置文件中
         */
//        String url = "jdbc:mysql:///spring_data";
//        String username = "root";
//        String password = "123456";
//        String driverClass = "com.mysql.jdbc.Driver";

        InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        String driverClass = properties.getProperty("jdbc.driver");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;

    }

    /**
     * 释放db相关资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
