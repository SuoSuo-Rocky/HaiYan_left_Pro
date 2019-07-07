package com;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("userid");//从JSP 获取数据
		HttpSession session=request.getSession();//创建保存数据对象
		int userid=Integer.valueOf(id);
		
		DBUtil db=new DBUtil();
		db.conn();
		try {
			String sql="select * from User_1 where userid="+userid;
			ResultSet rs=db.getrs(sql);
			if(rs.next()){
				User_1 shi=new User_1();
				shi.setUserid(rs.getInt(1));
				shi.setUsername(rs.getString(2));
				shi.setPassword(rs.getString(3));
				session.setAttribute("userinfo",shi);//保存数据
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("Userinfo.jsp");//跳转界面到 JSP
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
