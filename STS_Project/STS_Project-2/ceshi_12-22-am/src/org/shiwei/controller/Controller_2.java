package org.shiwei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shi")
public class Controller_2 {
	
	
	@RequestMapping("two")
	public String  two() {
		System.out.println("22222222");
		return "success";
	}
	

}
