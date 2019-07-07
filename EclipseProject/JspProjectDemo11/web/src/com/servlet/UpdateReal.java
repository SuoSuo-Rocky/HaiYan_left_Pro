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
 * Servlet implementation class UpdateReal
 */
public class UpdateReal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReal() {
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
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("userid");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		DBHelper db = new DBHelper();
		db.conn();
		String sql = "update users set username='"+username+"', userpassword='"+userpwd+"' where id="+id;
		int n = db.DoUpdate(sql);
		// �жϸ����Ƿ�ɹ�
		if(n > 0){
			try{
				String sql1 = "select * from users ";
				ResultSet rs = db.getRS(sql1); // ��ȡ���е�����
				// ���弯��,������������
				ArrayList list = new ArrayList();
				// �ѽ�����浽��װ����
				while(rs.next()){
					User u = new User();
					u.setId(rs.getInt(1));
					u.setUsername(rs.getString(2));
					u.setUserpassword(rs.getString(3));
					list.add(u); // �򼯺����������
				}
				// ���ڱ�������
				HttpSession session = request.getSession();
				session.setAttribute("userList", list);
				
				response.sendRedirect("success.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {	
		}
	}

}
