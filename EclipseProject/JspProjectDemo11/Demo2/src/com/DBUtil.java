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
        System.out.println("�������سɹ�����������");
    } catch (ClassNotFoundException ex) {
        System.out.println("��������ʧ�ܣ�������");
    }
      String url="jdbc:mysql://localhost:3306/mydb";
      String user="root";
      String password="666666";
    try {
        conn=DriverManager.getConnection(url, user, password);
        System.out.println("��ȡ���ӳɹ�����"); 
    } catch (SQLException ex) {
        System.out.println("����ʧ�ܣ���鿴�˺ź������Ƿ���ȷ��");
    }
}
//��ѯ��ȡ���������
public ResultSet getrs(String sql){
	  ResultSet rs=null;
	  Statement stmt=null;
	    try {
	        stmt=conn.createStatement();
	       // System.out.println("������󴴽��ɹ�������");
	    } catch (SQLException ex) {
	        System.out.println("������󴴽�ʧ�ܣ�����");
	    }
	   
	    try {
	        rs=stmt.executeQuery(sql);
	        System.out.println("��ѯ�ɹ�������");
	    } catch (SQLException ex) {
	    	System.out.println("��ѯʧ�ܣ�������");
	    }
	  return rs;
}

//�����ݽ��и��£�����ɾ����
public int   DoUpdate(String sql){
	Statement stmt=null;
	int rs=0;
	 try {
	        stmt=conn.createStatement();
	    } catch (SQLException ex) {
	        System.out.println("������󴴽�ʧ�ܣ�");
	    }
	   try {
		rs=stmt.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
}

//�ر����ݿ�����
public void close(){
	try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
