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
		//��ѯ��������
		String  sql="select userid,username,password from User_1";
		 rs=db.getrs(sql);
		User_1 dd=null;
        Vector<User_1> shi=new Vector<User_1>();//����һ�������
	 try {
		 while(rs.next()){
			dd=new User_1();//����һ�ű�
		    dd.setUserid(rs.getInt(1));
		    dd.setUsername(rs.getString(2));
		    dd.setPassword(rs.getString(3));
		    shi.add(dd);//�򼯺����������Ϊһ�ű�
		 }
		System.out.println("�޸�ʱ��ѯ�������ݳɹ���������");
	} catch (SQLException e) {
	System.out.println("�޸�ʱ��ѯ��������ʧ�ܣ�����");
	}
		
		HttpSession session=request.getSession();//��������
		session.setAttribute("Alluser",shi);//ǰ��Ϊ������������Ϊֵ��һ������
		
		response.sendRedirect("SelectAll.jsp");//��תҳ��
		
		
	}

}
