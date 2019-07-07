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
	 *      	普通用户登陆信息的处理
	 */

	@RequestMapping(value="deng.do")
	 public  void querstuById(Model model,Login login,HttpServletResponse response,
		HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		if(login.getPassword() == 666 && login.getStuName().equals("666")) {
			 response.sendRedirect("manager.do");
					
		}else {
		int news =(int) session.getAttribute("news");
			System.out.println("我获得到的Session_news = " + news);
			
			  if(news == 3) {
				 Login log = loginService.queryLoginBystuId(login.getStuId());
				System.out.println(log);
				if(log == null) {
					JOptionPane.showMessageDialog(null, "账号或密码输入错误 ！\n 请重新输入！ ");
					model.addAttribute("al", 1);
					response.sendRedirect("deng.jsp");
				}else if(log.getPassword() == login.getPassword() && log.getStuName().equals(login.getStuName())) {
				
					session.setAttribute("userid", login.getStuId());
					System.out.println("在Controller 中放的 userid=" + login.getStuId());

					
					List<Book>  books = loginService.queryAllbook();
					request.setAttribute("books", books);
					request.getRequestDispatcher("good.jsp").forward(request, response);
				}else {
					JOptionPane.showMessageDialog(null, "账号或密码输入错误 ！\n 请重新输入！ ");
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
	 * 对我的书架的信息处理
	 */

	@RequestMapping("mybook.do")
	public void queryMyBook(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");

		/* 获得我的 书架上的 所有书的 boid */
		List<Self> allSelf = loginService.queryAllSelf(userid);
		List<Book> mybook = new ArrayList<Book>();
		for (int i = 0; i < allSelf.size(); i++) {
			Book book = new Book();
			/* 根据我的所有书的 boid 来获得 我的每一本书的信息，用于展示 */
			book = loginService.querybookMessage(allSelf.get(i).getBoId());
			if(book!=null) {
				mybook.add(book);
			}
		}
		System.out.println(mybook);
		request.setAttribute("mybook", mybook);
		request.getRequestDispatcher("mybook.jsp").forward(request, response);
	}

    /* 从自己的书架上 删除书籍  */
	@RequestMapping("delete.do")
	public void delete(@RequestParam("boid") int boid, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int stuid = (int) session.getAttribute("userid");
		Self self = new Self();
		self.setBoId(boid);
		self.setStuId(stuid);
		System.out.println("要删除的：" + self);
		loginService.deleteSelfByHost(self);
		Self self2 = loginService.querySelfByHost(self);
		System.out.println("删完之后查询到的：" + self2);
		if (self2 == null) {
			request.getRequestDispatcher("mybook.do").forward(request, response);
		} else {
			JOptionPane.showMessageDialog(null, "删除书籍失败！");
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
				JOptionPane.showMessageDialog(null, "操作失败!");
			} else {
				JOptionPane.showMessageDialog(null, "此书添加到你的 书架，\n 操作成功!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "此书已经 存在与于你的 书架上了 ！ ");
		}

		List<Book> books = loginService.queryAllbook();
		request.setAttribute("books", books);
		request.getRequestDispatcher("good.jsp").forward(request, response);
	}
	
	
	/* 进入管理员的 登录界面 */
	@RequestMapping(value="manager.do")
	 public  void querstuById2(Model model,Login login,HttpServletResponse response,
			 HttpServletRequest request) throws Exception{
		
		List<Book>  books = loginService.queryAllbook();
		request.setAttribute("books", books);
		request.getRequestDispatcher("manager.jsp").forward(request, response);
	}
	
	/* 管理员 从书库中删除书籍 */
	@RequestMapping("shanchu.do")
	public void shanchuBook(@RequestParam("boid") int boid,HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 loginService.deletebookByboId(boid);
		 
		 Book book = loginService.querybookByboId(boid);
		 if(book == null) {
			 JOptionPane.showMessageDialog(null, "删除书籍成功！");
		 }else {
			 JOptionPane.showMessageDialog(null, "删除书籍失败！");
		 }
	request.getRequestDispatcher("manager.do").forward(request, response);
		
	}
	
	/*修改 仓库中 的 书籍*/
	@RequestMapping("update.do")
    public void xiugaiBook(Book book,HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int boid = (int)session.getAttribute("boid");
		System.out.println("获得到的 ：" + boid);
		
				book.setBoId(boid);
		loginService.updatebookById(book);
		
		System.out.println("提交上来的： " + book);
		
		Book bo = loginService.querybookByboId(boid);
		System.out.println("查出来的：" + bo );
		if(bo.getBoName().equals(book.getBoName()) && bo.getBoRank() == book.getBoRank()
				&& bo.getBoImg().equals(book.getBoImg())) {
			JOptionPane.showMessageDialog(null, "修改书籍成功！");
		}else {
			JOptionPane.showMessageDialog(null, "修改书籍失败！");
		}
		request.getRequestDispatcher("manager.do").forward(request, response);
    }
	
	/*添加一本书到 书库中*/
	@RequestMapping("addimg.do")
	public void  addBookImg(Book book,HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		loginService.addBookImg(book);
		
		Book book2 = loginService.querybookByboId(book.getBoId());
		if(book2 != null) {
			JOptionPane.showMessageDialog(null, "添加图书成功！");
		}else {
			JOptionPane.showMessageDialog(null, "添加图书失败！");
		}
		request.getRequestDispatcher("manager.do").forward(request, response);
	}
	
	/*添加账户信息*/
	@RequestMapping("addlogin.do")
	public void addLogin(@RequestParam("again") int again,Login login,HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("0000000000:" + login.getStuName());
		loginService.addLogin(login);
		
		Login login2 = loginService.queryLoginBystuId(login.getStuId());
		System.out.println("3333333333:" + login2.getStuName());
		if(login2.getStuName().equals(login.getStuName())) {
			JOptionPane.showMessageDialog(null, "添加成功！请登录！");
			request.getRequestDispatcher("deng.jsp").forward(request, response);
		}else {
			JOptionPane.showMessageDialog(null, "添加失败！请重新输入！");
			request.getRequestDispatcher("addLogin.jsp").forward(request, response);
		}
	}
	
	
	/*查询 图书信息*/
	@RequestMapping("search.do")
	public ModelAndView searchBookMessage(@RequestParam("text") String text) {
		
		Book book = loginService.searchbookByboName(text);
		ModelAndView gh = new ModelAndView("message");
		gh.addObject("book", book);
		
		return gh;
	}
	

}
