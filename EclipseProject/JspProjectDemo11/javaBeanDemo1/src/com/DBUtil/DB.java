package com.DBUtil;

import java.sql.Connection;

public class DB {
	String hu = "com.mysql.jdbc.Driver";
	String user = "root";
	String password = "666666";
	String sql = "select *  form mydb";
	Connection conn = null;
	
public DB() {
	
}
public Connection getconn(){
	
	
	
	return conn; 
}



}
