package com;

import java.awt.List;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login2
 */
@WebServlet("/Login2")
public class Login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login2() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //设置所获取的请求数据的编码格式
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		DBUtil db=new DBUtil();
		ResultSet rs=null;
		db.conn();
		
		try {
			String sql="select userid from User_1  where username='"+username+"' and  password='"+password+"'";
			 rs=db.getrs(sql);
            } catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				try {
				String sql="select userid from User_1  where username='"+username+"' and  password='"+password+"'";
  ResultSet rs2=db.getrs(sql);
			   
					if (rs2.next()){    
						System.out.println("验证成功！");
					        response.sendRedirect("Menu.jsp");
					    }else{
					    	response.sendRedirect("Login2.jsp");
					    }
				} catch (SQLException e) {
					e.printStackTrace();
				}
				

			
			
			}else{
				response.sendRedirect("Login2.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
