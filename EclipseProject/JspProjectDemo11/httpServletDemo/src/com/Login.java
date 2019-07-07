package com;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class Login extends HttpServlet {
	/**
	 * 对用户登录信息进行检验
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //设置所获取的请求数据的编码格式
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		DBUtil db=new DBUtil();
		ResultSet rs=null;
		db.conn();
		
		try {
			String sql="select username,password,level from userlogin  where username='"+username+"' and  password='"+password+"'";
			 rs=db.getrs(sql);
     

					if (rs.next()){  
								String level=rs.getString(3);
								if(level.equals("1")){
		 							JOptionPane.showMessageDialog(null, "权限错误！");
		 							db.close();
									response.sendRedirect("login.jsp");
								}else{
									System.out.println("验证成功！");
									db.close();
								    response.sendRedirect("LoginSuccess.html");
								}
							
					    }else{
					    	JOptionPane.showMessageDialog(null, "账号或密码输入错误！请重新输入....");
					    	db.close();
					    	response.sendRedirect("login.jsp");
					    }
		} catch (SQLException e) {
			e.printStackTrace();
				}

		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
	

}
