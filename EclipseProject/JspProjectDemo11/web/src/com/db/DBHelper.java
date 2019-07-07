package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {

    Connection con=null;
    // 获取数据库连接
    public void conn(){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String uri="jdbc:sqlserver://localhost:1433;DatabaseName=test";
                String user="sa";
                String password="123456";
                con=DriverManager.getConnection(uri,user,password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    // 获取结果集
    public ResultSet getRS(String sql) throws SQLException
    {
        Statement s;
        s = con.createStatement();
        return s.executeQuery(sql);
    }
    // 更新数据的方法
    public int DoUpdate(String sql)
    {
    	int n = 0;
        Statement s;
        try {
            s = con.createStatement();
            n = s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
    // 关闭数据库连接
    public void close(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
