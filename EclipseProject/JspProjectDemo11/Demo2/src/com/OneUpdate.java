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
 * Servlet implementation class OneUpdate
 */
@WebServlet("/OneUpdate")
public class OneUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneUpdate() {
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
		int rs=0;
		String userid=request.getParameter("userid");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		DBUtil db=new DBUtil();
		db.conn();
		String sql="update User_1 set userid='"+userid+"',username='"+username+"',password='"+password+"'";
		rs=db.DoUpdate(sql);
		//�ж��Ƿ���³ɹ�����
		
		
		
		
		if(rs>0){
		
		//��ѯ��������
	ResultSet rs22;
		String  sql22="select userid,username,password from User_1";
		 rs22=db.getrs(sql22);
		User_1 dd=null;
        Vector<User_1> shi=new Vector<User_1>();//����һ�������
	 try {
		while(rs22.next()){
			dd=new User_1();//����һ�ű�
			 for (int i = 0; i < 3; i++) {
				 dd.setUserid(rs22.getInt(1));
				 dd.setUsername(rs22.getString(2));
				 dd.setPassword(rs22.getString(3));
				 shi.add(dd);//�򼯺����������Ϊһ�ű�
			 }
		 }
		System.out.println("��ѯ�������ݳɹ���������");

	System.out.println("��ѯ��������ʧ�ܣ�����");
	
		
		HttpSession session=request.getSession();//��������
		session.setAttribute("Alluser", shi);//ǰ��Ϊ������������Ϊֵ��һ������
		
		response.sendRedirect("SelectAll.jsp");//��תҳ��
			} catch (SQLException e) {
			}	
	}
		}
		
		
}	
		
		
		
	
