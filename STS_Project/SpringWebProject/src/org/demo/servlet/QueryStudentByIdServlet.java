package org.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.service.IStudentService;
import org.demo.service.impl.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class QueryStudentByIdServlet
 */

public class QueryStudentByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IStudentService studentService;
	
    /*
     * Servlet  ��ʼ���������ڳ�ʼ�� ʱ �� ��ȡ Spring IOC �����е�  bean ����
     * @see javax.servlet.GenericServlet#init()
     */
	@Override
	public void init() throws ServletException {
    //java ��Ŀ ��ȡ  Bean �ķ�ʽ
//	ApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext-Services.xml");
		
	// �� Web ��Ŀ ����ͨ�� spring-web.jar ���ṩ�� WebApplicationContextUtils  ������ȡ Bean 
   ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());	
	//��ǰ���� IOC ������ ��ͨ�� getBean()  ��ȡIOC �����е� Bean 
 	this.studentService = (IStudentService)context.getBean("studentService");
	}
	
	
	

	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryStudentByIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		studentService
	    String name =  studentService.queryStudentById();
	    request.setAttribute("name", name);
	    request.getRequestDispatcher("result.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    	doGet(request, response);
	}

}