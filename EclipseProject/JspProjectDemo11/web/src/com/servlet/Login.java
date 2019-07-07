package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.db.DBHelper;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		// ���ڱ�������
		HttpSession session = request.getSession();
		DBHelper db = new DBHelper();
		db.conn();
		try {
			String sql = "select * from users where username='"+username+"' and userpassword='"+userpwd+"'";
			ResultSet rs = db.getRS(sql);
			// ����û���������������ȷ
			if(rs.next()){
				String sql1 = "select * from users ";
				ResultSet rs1 = db.getRS(sql1); // ��ȡ���е�����
				// ���弯��,������������
				ArrayList list = new ArrayList();
				// �ѽ�����浽��װ����
				while(rs1.next()){
					User u = new User();
					u.setId(rs.getInt(1));
					u.setUsername(rs.getString(2));
					u.setUserpassword(rs.getString(3));
					list.add(u); // �򼯺����������
				}
				
				session.setAttribute("userList", list);
				
				response.sendRedirect("success.jsp");
			} else {
				session.setAttribute("flag", "0");
				response.sendRedirect("login.jsp");
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
