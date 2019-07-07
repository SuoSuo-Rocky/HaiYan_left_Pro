package org.shiwei.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {
	
	
	@RequestMapping("/one")
	public void   test(HttpServletResponse response) throws IOException, ServletException {
		System.out.println(11111);
		response.sendRedirect("/one_2");
		
	}
	
	@RequestMapping("/one_2")
	public String test_2() {
		System.out.println("test_2");
		return "success";
	}

}
