// 数据库连接类
package com.db;

import java.sql.*;

public class DbConnect {
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/text1?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "yanzeyu1101";

    // 连接对象
    protected Connection conn = null;

    protected DbConnect(){
        toConnect();
    }

    protected void toConnect(){
        try {
            // 注册 JDBC 驱动
            //Class.forName(JDBC_DRIVER);

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
}
