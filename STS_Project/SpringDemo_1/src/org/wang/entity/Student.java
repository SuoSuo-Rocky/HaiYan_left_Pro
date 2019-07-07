package org.wang.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wang.newinstance.HtmlCourse;
import org.wang.newinstance.ICourse;
import org.wang.newinstance.JavaCourse;

public class Student {
	private int stuNo;
	private String stuName;
	private int stuAge;
	
	
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	@Override
	public String toString() {
	
		return this.stuNo+ "," + this.stuName + "," + this.stuAge ;
	}
	
	
	//ѧϰ Java  �γ�
	public void LearnJava(){
		JavaCourse course = new JavaCourse();
		course.learn();
	}
	// ѧϰ  html �γ�
	public void LearnHTML() {
		HtmlCourse course = new HtmlCourse();
		course.learn();
	}
	
	 public void learn(String name) {
		 //�Ӽ򵥹���ʽ �� IOC �л�ȡ����
		 /*  ICourse course = CourseFactory.getCourse(name);
		   course.learn();*/
		 
		 //ֱ�Ӵ� IOC �����л�ȡ����(ǰ���������� �Ѿ������ Bean)
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 ICourse course = (ICourse) context.getBean(name);
		 course.learn();
		 
	  }

}
