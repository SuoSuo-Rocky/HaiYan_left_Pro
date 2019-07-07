package com.db;

import java.sql.*;
public class DBConn {
    Connection conn=null;
    public Connection getConnection() {
       String url="jdbc:mysql://localhost:3306/mydb"; 
       String user="root";
       String password="666666"; 
       try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url, user, password);
            return conn;
       } catch (Exception e) {
            e.printStackTrace();
            return null;
      }
    } 
    public void close(){
      try{
         if(conn!=null) conn.close(); 
      }catch(Exception e){}
    }
}
