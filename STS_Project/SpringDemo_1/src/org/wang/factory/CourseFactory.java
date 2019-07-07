package org.wang.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wang.newinstance.ICourse;

public class CourseFactory {
	public static ICourse getCourse(String name) {
//		ÏÈ´´½¨ÈÝÆ÷
		ApplicationContext context = new ClassPathXmlApplicationContext();
		if (name.equals("java")) {
			return (ICourse) context.getBean("javaCourse");
		} else if (name.equals("html")) {
			return (ICourse) context.getBean("htmlCourse");
		} else {
			return null;
		}
	}
}
