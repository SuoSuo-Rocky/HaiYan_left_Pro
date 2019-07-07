package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


 public class DBUtil {
	 
	public   Connection conn=null;
	
	
public void conn(){
	
	try {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("驱动加载成功！！！！！");
    } catch (ClassNotFoundException ex) {
        System.out.println("驱动加载失败！！！！");
    }
      String url="jdbc:mysql://localhost:3306/mydb";
      String user="root";
      String password="666666";
    try {
        conn=DriverManager.getConnection(url, user, password);
        System.out.println("获取链接成功！！"); 
    } catch (SQLException ex) {
        System.out.println("连接失败，请查看账号和密码是否正确！");
    }
}
//查询获取结果集，查
public ResultSet getrs(String sql){
	  ResultSet rs=null;
	  Statement stmt=null;
	    try {
	        stmt=conn.createStatement();
	       // System.out.println("命令对象创建成功！！！");
	    } catch (SQLException ex) {
	        System.out.println("命令对象创建失败！！！");
	    }
	   
	    try {
	        rs=stmt.executeQuery(sql);
	        System.out.println("查询成功！！！");
	    } catch (SQLException ex) {
	    	System.out.println("查询失败！！！！");
	    }
	  return rs;
}

//对数据进行更新，增，删，改
public int   DoUpdate(String sql){
	Statement stmt=null;
	int rs=0;
	 try {
	        stmt=conn.createStatement();
	    } catch (SQLException ex) {
	        System.out.println("命令对象创建失败！");
	    }
	   try {
		rs=stmt.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
}

//关闭数据库链接
public void close(){
	try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
