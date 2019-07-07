package org.shiwei.controller;

import javax.swing.JOptionPane;

import org.shiwei.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("SpringMVC")
public class MyController {
	
	@Autowired
	MessageService  service;

	public MessageService getService() {
		return service;
	}

	public void setService(MessageService service) {
		this.service = service;
	}
	
	@RequestMapping("one.do")
	public String  shiyan() {
		JOptionPane.showMessageDialog(null, "hello");
		return "success";
	}

}
