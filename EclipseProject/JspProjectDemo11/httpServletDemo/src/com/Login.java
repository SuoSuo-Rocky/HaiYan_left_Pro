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
	 * ���û���¼��Ϣ���м���
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //��������ȡ���������ݵı����ʽ
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
		 							JOptionPane.showMessageDialog(null, "Ȩ�޴���");
		 							db.close();
									response.sendRedirect("login.jsp");
								}else{
									System.out.println("��֤�ɹ���");
									db.close();
								    response.sendRedirect("LoginSuccess.html");
								}
							
					    }else{
					    	JOptionPane.showMessageDialog(null, "�˺Ż����������������������....");
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
