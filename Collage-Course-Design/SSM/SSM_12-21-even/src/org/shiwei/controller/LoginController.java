package org.shiwei.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.shiwei.entity.Book;
import org.shiwei.entity.Login;
import org.shiwei.entity.Self;
import org.shiwei.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	public LoginController() {

	}

	@Autowired
	ILoginService loginService;
	
	/*
	 *      	��ͨ�û���½��Ϣ�Ĵ���
	 */

	@RequestMapping(value="deng.do")
	 public  void querstuById(Model model,Login login,HttpServletResponse response,
		HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		if(login.getPassword() == 666 && login.getStuName().equals("666")) {
			 response.sendRedirect("manager.do");
					
		}else {
		int news =(int) session.getAttribute("news");
			System.out.println("�һ�õ���Session_news = " + news);
			
			  if(news == 3) {
				 Login log = loginService.queryLoginBystuId(login.getStuId());
				System.out.println(log);
				if(log == null) {
					JOptionPane.showMessageDialog(null, "�˺Ż������������ ��\n ���������룡 ");
					model.addAttribute("al", 1);
					response.sendRedirect("deng.jsp");
				}else if(log.getPassword() == login.getPassword() && log.getStuName().equals(login.getStuName())) {
				
					session.setAttribute("userid", login.getStuId());
					System.out.println("��Controller �зŵ� userid=" + login.getStuId());

					
					List<Book>  books = loginService.queryAllbook();
					request.setAttribute("books", books);
					request.getRequestDispatcher("good.jsp").forward(request, response);
				}else {
					JOptionPane.showMessageDialog(null, "�˺Ż������������ ��\n ���������룡 ");
					model.addAttribute("al", 1);
					response.sendRedirect("deng.jsp");
				}
		}else {
				List<Book>  books = loginService.queryAllbook();
				request.setAttribute("books", books);
				request.getRequestDispatcher("good.jsp").forward(request, response);
			}
		}
	}
	
	
	@RequestMapping("deng2.do")
	public void manager(HttpServletResponse response,
			 HttpServletRequest request) throws ServletException, IOException {

		List<Book>  books = loginService.queryAllbook();
		request.setAttribute("books", books);
		request.getRequestDispatcher("good.jsp").forward(request, response);
		
	}
	
	/*
	 * ���ҵ���ܵ���Ϣ����
	 */

	@RequestMapping("mybook.do")
	public void queryMyBook(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");

		/* ����ҵ� ����ϵ� ������� boid */
		List<Self> allSelf = loginService.queryAllSelf(userid);
		List<Book> mybook = new ArrayList<Book>();
		for (int i = 0; i < allSelf.size(); i++) {
			Book book = new Book();
			/* �����ҵ�������� boid ����� �ҵ�ÿһ�������Ϣ������չʾ */
			book = loginService.querybookMessage(allSelf.get(i).getBoId());
			if(book!=null) {
				mybook.add(book);
			}
		}
		System.out.println(mybook);
		request.setAttribute("mybook", mybook);
		request.getRequestDispatcher("mybook.jsp").forward(request, response);
	}

    /* ���Լ�������� ɾ���鼮  */
	@RequestMapping("delete.do")
	public void delete(@RequestParam("boid") int boid, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int stuid = (int) session.getAttribute("userid");
		Self self = new Self();
		self.setBoId(boid);
		self.setStuId(stuid);
		System.out.println("Ҫɾ���ģ�" + self);
		loginService.deleteSelfByHost(self);
		Self self2 = loginService.querySelfByHost(self);
		System.out.println("ɾ��֮���ѯ���ģ�" + self2);
		if (self2 == null) {
			request.getRequestDispatcher("mybook.do").forward(request, response);
		} else {
			JOptionPane.showMessageDialog(null, "ɾ���鼮ʧ�ܣ�");
		}
	}
	
	@RequestMapping("shelf.do")
	public void addShelf(@RequestParam("boid") int boid, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");
		Self self = new Self();
		self.setBoId(boid);
		self.setStuId(userid);
		Self self2 = loginService.querySelfByHost(self);
		if (self2 == null) {
			loginService.addSelfBook(self);
			Self self3 = loginService.querySelfByHost(self);
			if (self3 == null) {
				JOptionPane.showMessageDialog(null, "����ʧ��!");
			} else {
				JOptionPane.showMessageDialog(null, "������ӵ���� ��ܣ�\n �����ɹ�!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "�����Ѿ� ����������� ������� �� ");
		}

		List<Book> books = loginService.queryAllbook();
		request.setAttribute("books", books);
		request.getRequestDispatcher("good.jsp").forward(request, response);
	}
	
	
	/* �������Ա�� ��¼���� */
	@RequestMapping(value="manager.do")
	 public  void querstuById2(Model model,Login login,HttpServletResponse response,
			 HttpServletRequest request) throws Exception{
		
		List<Book>  books = loginService.queryAllbook();
		request.setAttribute("books", books);
		request.getRequestDispatcher("manager.jsp").forward(request, response);
	}
	
	/* ����Ա �������ɾ���鼮 */
	@RequestMapping("shanchu.do")
	public void shanchuBook(@RequestParam("boid") int boid,HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 loginService.deletebookByboId(boid);
		 
		 Book book = loginService.querybookByboId(boid);
		 if(book == null) {
			 JOptionPane.showMessageDialog(null, "ɾ���鼮�ɹ���");
		 }else {
			 JOptionPane.showMessageDialog(null, "ɾ���鼮ʧ�ܣ�");
		 }
	request.getRequestDispatcher("manager.do").forward(request, response);
		
	}
	
	/*�޸� �ֿ��� �� �鼮*/
	@RequestMapping("update.do")
    public void xiugaiBook(Book book,HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int boid = (int)session.getAttribute("boid");
		System.out.println("��õ��� ��" + boid);
		
				book.setBoId(boid);
		loginService.updatebookById(book);
		
		System.out.println("�ύ�����ģ� " + book);
		
		Book bo = loginService.querybookByboId(boid);
		System.out.println("������ģ�" + bo );
		if(bo.getBoName().equals(book.getBoName()) && bo.getBoRank() == book.getBoRank()
				&& bo.getBoImg().equals(book.getBoImg())) {
			JOptionPane.showMessageDialog(null, "�޸��鼮�ɹ���");
		}else {
			JOptionPane.showMessageDialog(null, "�޸��鼮ʧ�ܣ�");
		}
		request.getRequestDispatcher("manager.do").forward(request, response);
    }
	
	/*���һ���鵽 �����*/
	@RequestMapping("addimg.do")
	public void  addBookImg(Book book,HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		loginService.addBookImg(book);
		
		Book book2 = loginService.querybookByboId(book.getBoId());
		if(book2 != null) {
			JOptionPane.showMessageDialog(null, "���ͼ��ɹ���");
		}else {
			JOptionPane.showMessageDialog(null, "���ͼ��ʧ�ܣ�");
		}
		request.getRequestDispatcher("manager.do").forward(request, response);
	}
	
	/*����˻���Ϣ*/
	@RequestMapping("addlogin.do")
	public void addLogin(@RequestParam("again") int again,Login login,HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("0000000000:" + login.getStuName());
		loginService.addLogin(login);
		
		Login login2 = loginService.queryLoginBystuId(login.getStuId());
		System.out.println("3333333333:" + login2.getStuName());
		if(login2.getStuName().equals(login.getStuName())) {
			JOptionPane.showMessageDialog(null, "��ӳɹ������¼��");
			request.getRequestDispatcher("deng.jsp").forward(request, response);
		}else {
			JOptionPane.showMessageDialog(null, "���ʧ�ܣ����������룡");
			request.getRequestDispatcher("addLogin.jsp").forward(request, response);
		}
	}
	
	
	/*��ѯ ͼ����Ϣ*/
	@RequestMapping("search.do")
	public ModelAndView searchBookMessage(@RequestParam("text") String text) {
		
		Book book = loginService.searchbookByboName(text);
		ModelAndView gh = new ModelAndView("message");
		gh.addObject("book", book);
		
		return gh;
	}
	

}
