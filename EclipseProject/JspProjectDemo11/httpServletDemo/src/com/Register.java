package com;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class Register extends HttpServlet {
	/**
	 * 对用户注册信息进行处理
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //设置所获取的请求数据的编码格式
		String[] info=new String[11]; 
		String[] info2=new String[3]; 
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String age=request.getParameter("age");
		String id_card=request.getParameter("id_card");
		String born=request.getParameter("born");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String nextpassword=request.getParameter("nextpassword");
		
	   info[0]=id;
	   info[1]=name;
	   info[2]=sex;
	   info[3]=age;
	   info[4]=id_card;
	   info[5]=born;
   	   info[6]=address;
	   info[7]=phone;
	   info[8]=username;
	   info[9]=password;
	   info[10]=nextpassword;
       
	   info2[0]=username;
	   info2[1]=password;
	   info2[2]="0";
	   
	   String  sql1="insert into info_basic (id,name,sex,age,id_card,born,address,phone,username,password,nextpassword)"
	   		+ " values(?,?,?,?,?,?,?,?,?,?,?)";
	   String sql2="insert into userlogin(username,password,level) values (?,?,?)";
		DBUtil db=new DBUtil();
	
		db.conn();
		int rs=0;
		rs=db.DoUpdate(sql1, info);
		rs=db.DoUpdate(sql2, info2);
		
		if(rs==1){
			JOptionPane.showMessageDialog(null, "注册成功！ 请登录......");
			db.close();
			response.sendRedirect("login.jsp");
		}else{
			JOptionPane.showMessageDialog(null, "有误！");
			db.close();
			response.sendRedirect("register.jsp");
		}
		
		
		
		
		
		
		
		

	}
	
	
	
	

}
