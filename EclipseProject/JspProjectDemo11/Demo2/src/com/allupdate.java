package com;

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
 * Servlet implementation class allupdate
 */
@WebServlet("/allupdate")
public class allupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allupdate() {
        super();
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
		DBUtil db=new DBUtil();
		ResultSet rs=null;
		db.conn();
		//查询所有数据
		String  sql="select userid,username,password from User_1";
		 rs=db.getrs(sql);
		User_1 dd=null;
        Vector<User_1> shi=new Vector<User_1>();//定义一个结果集
	 try {
		 while(rs.next()){
			dd=new User_1();//创建一张表
		    dd.setUserid(rs.getInt(1));
		    dd.setUsername(rs.getString(2));
		    dd.setPassword(rs.getString(3));
		    shi.add(dd);//向集合中添加数据为一张表
		 }
		System.out.println("修改时查询所有数据成功！！！！");
	} catch (SQLException e) {
	System.out.println("修改时查询所有数据失败！！！");
	}
		
		HttpSession session=request.getSession();//保存数据
		session.setAttribute("Alluser",shi);//前者为变量名，后者为值是一个集合
		
		response.sendRedirect("SelectAll.jsp");//跳转页面
		
		
	}

}
