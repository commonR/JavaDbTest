// 数据库连接模型子类
package com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbModel_1 extends DbConnect{
    public DbModel_1(){
        super();
    }

    public void select(){
        // 操作数据库接口
        Statement stmt = null;
        try {
            if(conn == null){
                this.toConnect();
            }

            // 执行查询
            stmt = conn.createStatement();
            String sql = "SELECT * FROM class";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("classid");
                String name = rs.getString("classname");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", name: " + name);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            // 关闭资源
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

}
