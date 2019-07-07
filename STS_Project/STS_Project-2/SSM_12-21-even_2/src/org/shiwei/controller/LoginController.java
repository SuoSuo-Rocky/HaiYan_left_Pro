package org.shiwei.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.shiwei.entity.Book;
import org.shiwei.entity.Login;
import org.shiwei.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	public LoginController() {
		
		
	}
	
	@Autowired
	ILoginService loginService;
	
	public void setStudentService(ILoginService studentService) {
		this.loginService = studentService;
	}
	
	public ILoginService getStudentService() {
		return loginService;
	}
	@RequestMapping(value="deng.do", params= {"stuName","stuid"})
	 public  void querstuById(Model model,Login login,HttpServletResponse response) throws IOException{
		Login log = loginService.queryLoginBystuId(100);
		System.out.println(log);
		if(log == null) {
			JOptionPane.showMessageDialog(null, "账号或密码输入错误 ！\n 请重新输入！ ");
			model.addAttribute("al", 1);
			response.sendRedirect("deng.jsp");
		}else if(log.getPassword() == login.getPassword() && log.getStuName().equals(login.getStuName())) {
			model.addAttribute("login",log);
			List<Book>  books = loginService.queryAllbookByboId();
			System.out.println(books);
//			model.addAttribute("books", books);
			response.sendRedirect("good.jsp");
		}else {
			JOptionPane.showMessageDialog(null, "账号或密码输入错误 ！\n 请重新输入！ ");
			model.addAttribute("al", 1);
			response.sendRedirect("deng.jsp");
		}
		
	}
	
	

}
