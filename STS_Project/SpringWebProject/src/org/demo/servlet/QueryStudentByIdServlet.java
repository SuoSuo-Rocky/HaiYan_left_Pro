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
     * Servlet  初始化方法，在初始化 时 ， 获取 Spring IOC 容器中的  bean 对象。
     * @see javax.servlet.GenericServlet#init()
     */
	@Override
	public void init() throws ServletException {
    //java 项目 拿取  Bean 的方式
//	ApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext-Services.xml");
		
	// 而 Web 项目 可以通过 spring-web.jar 包提供的 WebApplicationContextUtils  类来获取 Bean 
   ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());	
	//当前是在 IOC 容器中 ，通过 getBean()  获取IOC 容器中的 Bean 
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
