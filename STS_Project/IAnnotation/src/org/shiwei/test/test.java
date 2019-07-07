package org.shiwei.test;

import org.shiwei.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class test {
       
	static 	IStudentService StudentService;
	public static void wang() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService = (IStudentService) context.getBean("StudentService");
	   
		String name = StudentService.queryStudentName();
		System.out.println(name);
		org.springframework.util.StringUtils.isEmpty(name);
	

	}
	



	public static void main(String[] args) {
	 wang();
	}
	

}
